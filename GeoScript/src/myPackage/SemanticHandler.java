package myPackage;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import org.antlr.runtime.Token;

public class SemanticHandler {
    public Map<String,String> colors = new HashMap<String,String>();
    public Map<String,Integer> vars = new HashMap<String,Integer>();
    public boolean canvasDefined = false;
    public int canvasW = 800;
    public int canvasH = 600;
    
    private StringBuilder svgContent = new StringBuilder();

    public void defineColor(String id, String hex) {
        colors.put(id, hex);
        System.out.println("Defined color " + id + " = " + hex);
    }

    public void checkColor(String name, Token tk) {
        if (name == null || name.startsWith("#")) return;
        if (!colors.containsKey(name))
            System.err.println("Warning: color '" + name + "' not defined at line " + tk.getLine());
    }

    public void defineVar(String id, int value) {
        vars.put(id, value);
        System.out.println("VAR " + id + " = " + value);
    }

    public int getVarValue(String id) {
        if (!vars.containsKey(id)) {
            System.err.println("Warning: variable '" + id + "' undefined (0 default)");
            return 0;
        }
        return vars.get(id);
    }

    public void setVar(String id, int value) {
        if (!vars.containsKey(id))
            System.err.println("Warning: assigning undeclared variable '" + id + "'");
        vars.put(id, value);
    }

    public void setCanvas(int w, int h) {
        canvasDefined = true;
        canvasW = w;
        canvasH = h;
        System.out.println("Canvas set to " + w + "x" + h);
    }

    public void addSvgElement(String element) {
        svgContent.append(element).append("\n");
    }

    public void exportSVG(String filename) {
        StringBuilder sb = new StringBuilder();
        sb.append("<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"").append(canvasW).append("\" height=\"").append(canvasH).append("\">\n");
        sb.append("<rect width=\"").append(canvasW).append("\" height=\"").append(canvasH).append("\" fill=\"white\"/>\n");
        sb.append(svgContent.toString());
        sb.append("</svg>");
        try {
            FileWriter fw = new FileWriter(filename);
            fw.write(sb.toString());
            fw.close();
            System.out.println("SVG exported to: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static interface Expr { int eval(SemanticHandler sem); }
    public static interface Command { void execute(SemanticHandler sem); }

    public static class ConstExpr implements Expr {
        int v;
        public ConstExpr(int v){ this.v = v; }
        public int eval(SemanticHandler s){ return v; }
    }

    public static class VarExpr implements Expr {
        String id;
        public VarExpr(String id){ this.id = id; }
        public int eval(SemanticHandler s){ return s.getVarValue(id); }
    }

    public static class BinExpr implements Expr {
        Expr left; Expr right; String op;
        public BinExpr(Expr l, String op, Expr r){ left=l; this.op=op; right=r; }
        public int eval(SemanticHandler s){
            int L = left.eval(s);
            int R = right.eval(s);
            if (op.equals("+")) return L+R;
            if (op.equals("-")) return L-R;
            if (op.equals("*")) return L*R;
            if (op.equals("/")) return R==0 ? 0 : L/R;
            if (op.equals("%")) return R==0 ? 0 : L % R; 
            if (op.equals("==")) return (L == R) ? 1 : 0;
            if (op.equals("!=")) return (L != R) ? 1 : 0;
            if (op.equals("<")) return (L < R) ? 1 : 0;
            if (op.equals(">")) return (L > R) ? 1 : 0;
            return 0;
        }
    }

    public static class VarDeclCommand implements Command {
        String id; Expr expr;
        public VarDeclCommand(String id, Expr e){ this.id=id; expr=e; }
        public void execute(SemanticHandler sem){ sem.defineVar(id, expr.eval(sem)); }
    }

    public static class AssignCommand implements Command {
        String id; Expr expr;
        public AssignCommand(String id, Expr e){ this.id=id; expr=e; }
        public void execute(SemanticHandler sem){ sem.setVar(id, expr.eval(sem)); }
    }

    public static class IfCommand implements Command {
        Expr cond; List<Command> thenBody; List<Command> elseBody;
        public IfCommand(Expr c, List<Command> t, List<Command> e){ cond=c; thenBody=t; elseBody=e; }
        public void execute(SemanticHandler sem){
            if (cond.eval(sem) != 0) {
                for(Command c: thenBody) c.execute(sem);
            } else if (elseBody != null) {
                for(Command c: elseBody) c.execute(sem);
            }
        }
    }

    public static class WhileCommand implements Command {
        Expr cond; List<Command> body;
        public WhileCommand(Expr c, List<Command> b){ cond=c; body=b; }
        public void execute(SemanticHandler sem){
            while (cond.eval(sem) != 0) {
                for(Command c: body) c.execute(sem);
            }
        }
    }

    public static class ForCommand implements Command {
        Command init; Expr cond; Command incr; List<Command> body;
        public ForCommand(Command init, Expr cond, Command incr, List<Command> body){
            this.init=init; this.cond=cond; this.incr=incr; this.body=body;
        }
        public void execute(SemanticHandler sem){
            if (init != null) init.execute(sem);
            while (cond.eval(sem) != 0) {
                for (Command c: body) c.execute(sem);
                if (incr != null) incr.execute(sem);
            }
        }
    }

    public static class ShapeCommand implements Command {
        String kind;
        Expr[] exprs;
        String fill; String stroke; Token fillToken; Token strokeToken;

        public ShapeCommand(String kind, Expr[] exprs, String fill, Token fillToken, String stroke, Token strokeToken){
            this.kind = kind; this.exprs = exprs; 
            this.fill = fill; this.fillToken = fillToken; 
            this.stroke = stroke; this.strokeToken = strokeToken;
        }

        public void execute(SemanticHandler sem){
            if (!sem.canvasDefined && !kind.equals("TEXT")) return; 
            if (fill != null && !fill.startsWith("#") && !kind.equals("TEXT")) sem.checkColor(fill, fillToken);
            if (stroke != null && !stroke.startsWith("#")) sem.checkColor(stroke, strokeToken);

            int[] nums = new int[exprs.length];
            for(int i=0; i<exprs.length; i++) nums[i] = exprs[i].eval(sem);

            String style = "";
            StringBuilder sb = new StringBuilder();
            if (fill != null && !kind.equals("TEXT")) {
                String c = fill.startsWith("#") ? fill : sem.colors.get(fill);
                sb.append(" fill=\"").append(c != null ? c : "none").append("\"");
            } else if (!kind.equals("TEXT")) {
                sb.append(" fill=\"none\"");
            }
            if (stroke != null) {
                String c = stroke.startsWith("#") ? stroke : sem.colors.get(stroke);
                sb.append(" stroke=\"").append(c != null ? c : "black").append("\" stroke-width=\"2\"");
            } else {
                sb.append(" stroke=\"none\"");
            }
            style = sb.toString();

            String svg = "";
            if (kind.equals("RECT")) {
                svg = "<rect x=\"" + nums[0] + "\" y=\"" + nums[1] + "\" width=\"" + nums[2] + "\" height=\"" + nums[3] + "\" " + style + " />";
            } 
            else if (kind.equals("CIRCLE")) {
                svg = "<circle cx=\"" + nums[0] + "\" cy=\"" + nums[1] + "\" r=\"" + nums[2] + "\" " + style + " />";
            }
            else if (kind.equals("LINE")) {
                svg = "<line x1=\"" + nums[0] + "\" y1=\"" + nums[1] + "\" x2=\"" + nums[2] + "\" y2=\"" + nums[3] + "\" " + style + " />";
            }
            else if (kind.equals("SQUARE")) {
                svg = "<rect x=\"" + nums[0] + "\" y=\"" + nums[1] + "\" width=\"" + nums[2] + "\" height=\"" + nums[2] + "\" " + style + " />";
            }
            else if (kind.equals("ELLIPSE")) {
                svg = "<ellipse cx=\"" + nums[0] + "\" cy=\"" + nums[1] + "\" rx=\"" + nums[2] + "\" ry=\"" + nums[3] + "\" " + style + " />";
            }
            else if (kind.equals("TRIANGLE")) {
                svg = "<polygon points=\"" + nums[0] + "," + nums[1] + " " + nums[2] + "," + nums[3] + " " + nums[4] + "," + nums[5] + "\" " + style + " />";
            }
            else if (kind.equals("POLYGON")) {
                StringBuilder pts = new StringBuilder();
                for(int i=0; i<nums.length; i+=2) pts.append(nums[i]).append(",").append(nums[i+1]).append(" ");
                svg = "<polygon points=\"" + pts.toString().trim() + "\" " + style + " />";
            }
            else if (kind.equals("TEXT")) {
                String textColor = "black";
                if (stroke != null) {
                    String c = stroke.startsWith("#") ? stroke : sem.colors.get(stroke);
                    if (c != null) textColor = c;
                }
                svg = "<text x=\"" + nums[0] + "\" y=\"" + nums[1] + "\" fill=\"" + textColor + "\">" + fill + "</text>";
            }
            
            sem.addSvgElement(svg);
        }
    }
}