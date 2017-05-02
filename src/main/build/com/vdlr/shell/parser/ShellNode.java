package com.vdlr.shell.parser;

/**
 * 
 * @author victor de la rosa @2016
 *
 */
public class ShellNode extends SimpleNode implements Node {

	private ShellParser shellParser;

	private int beginColumn;

	private int beginLine;

	private int endColum;

	private int endLine;

	private String image;

	private ShellNode parent;

	public ShellNode(ShellParser shellParser, int kind) {
		super(kind);
		this.shellParser = shellParser;
	}

	public void jjtOpen() {
		this.beginColumn = shellParser.token.beginColumn;
		this.beginLine = shellParser.token.beginLine;
		this.endColum = shellParser.token.endColumn;
		this.endLine = shellParser.token.endLine;
	}

	public void jjtClose() {
		this.image = shellParser.token.image;
		parent = (ShellNode) this.jjtGetParent();
	}

	public void jjtSetParent(Node n) {
		parent = (ShellNode) n;
	}

	public String toString() {
		return ShellParserTreeConstants.jjtNodeName[id] + (this.value == null ? "" : "  (" + this.value + ")");
	}

	

	public int getBeginColumn() {

		return this.beginColumn;
	}

	public int getBeginLine() {

		return this.beginLine;
	}

	public ShellNode getChild(int child) {

		return (ShellNode) jjtGetChild(child);
	}

	
	public int getEndColumn() {

		return this.endColum;
	}

	public int getEndLine() {

		return this.endLine;
	}

	
	public String getImage() {

		return this.image;
	}

	public int getNumChildren() {

		return jjtGetNumChildren();
	}

	public ShellNode getParent() {

		return this.parent;
	}

	public String getTypeName() {

		return ShellParserTreeConstants.jjtNodeName[id];
	}

	public boolean isTypeName(String typeName) {

		return typeName.equals(ShellParserTreeConstants.jjtNodeName[id]);
	}

}
