// Generated from C:/Users/Dell/IdeaProjects/valkyrie-intellij/src/main/antlr\Valkyrie.g4 by ANTLR 4.12.0
package valkyrie.language.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ValkyrieParser}.
 */
public interface ValkyrieListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ValkyrieParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ValkyrieParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#top_statement}.
	 * @param ctx the parse tree
	 */
	void enterTop_statement(ValkyrieParser.Top_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#top_statement}.
	 * @param ctx the parse tree
	 */
	void exitTop_statement(ValkyrieParser.Top_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#define_namespace}.
	 * @param ctx the parse tree
	 */
	void enterDefine_namespace(ValkyrieParser.Define_namespaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#define_namespace}.
	 * @param ctx the parse tree
	 */
	void exitDefine_namespace(ValkyrieParser.Define_namespaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#define_class}.
	 * @param ctx the parse tree
	 */
	void enterDefine_class(ValkyrieParser.Define_classContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#define_class}.
	 * @param ctx the parse tree
	 */
	void exitDefine_class(ValkyrieParser.Define_classContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#class_statements}.
	 * @param ctx the parse tree
	 */
	void enterClass_statements(ValkyrieParser.Class_statementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#class_statements}.
	 * @param ctx the parse tree
	 */
	void exitClass_statements(ValkyrieParser.Class_statementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#define_trait}.
	 * @param ctx the parse tree
	 */
	void enterDefine_trait(ValkyrieParser.Define_traitContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#define_trait}.
	 * @param ctx the parse tree
	 */
	void exitDefine_trait(ValkyrieParser.Define_traitContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#trait_statements}.
	 * @param ctx the parse tree
	 */
	void enterTrait_statements(ValkyrieParser.Trait_statementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#trait_statements}.
	 * @param ctx the parse tree
	 */
	void exitTrait_statements(ValkyrieParser.Trait_statementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#define_union}.
	 * @param ctx the parse tree
	 */
	void enterDefine_union(ValkyrieParser.Define_unionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#define_union}.
	 * @param ctx the parse tree
	 */
	void exitDefine_union(ValkyrieParser.Define_unionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#union_statements}.
	 * @param ctx the parse tree
	 */
	void enterUnion_statements(ValkyrieParser.Union_statementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#union_statements}.
	 * @param ctx the parse tree
	 */
	void exitUnion_statements(ValkyrieParser.Union_statementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#define_variale}.
	 * @param ctx the parse tree
	 */
	void enterDefine_variale(ValkyrieParser.Define_varialeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#define_variale}.
	 * @param ctx the parse tree
	 */
	void exitDefine_variale(ValkyrieParser.Define_varialeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#define_function}.
	 * @param ctx the parse tree
	 */
	void enterDefine_function(ValkyrieParser.Define_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#define_function}.
	 * @param ctx the parse tree
	 */
	void exitDefine_function(ValkyrieParser.Define_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#formal_args}.
	 * @param ctx the parse tree
	 */
	void enterFormal_args(ValkyrieParser.Formal_argsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#formal_args}.
	 * @param ctx the parse tree
	 */
	void exitFormal_args(ValkyrieParser.Formal_argsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#formal_arg}.
	 * @param ctx the parse tree
	 */
	void enterFormal_arg(ValkyrieParser.Formal_argContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#formal_arg}.
	 * @param ctx the parse tree
	 */
	void exitFormal_arg(ValkyrieParser.Formal_argContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntTypeSpec}
	 * labeled alternative in {@link ValkyrieParser#type}.
	 * @param ctx the parse tree
	 */
	void enterIntTypeSpec(ValkyrieParser.IntTypeSpecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntTypeSpec}
	 * labeled alternative in {@link ValkyrieParser#type}.
	 * @param ctx the parse tree
	 */
	void exitIntTypeSpec(ValkyrieParser.IntTypeSpecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FloatTypeSpec}
	 * labeled alternative in {@link ValkyrieParser#type}.
	 * @param ctx the parse tree
	 */
	void enterFloatTypeSpec(ValkyrieParser.FloatTypeSpecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FloatTypeSpec}
	 * labeled alternative in {@link ValkyrieParser#type}.
	 * @param ctx the parse tree
	 */
	void exitFloatTypeSpec(ValkyrieParser.FloatTypeSpecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringTypeSpec}
	 * labeled alternative in {@link ValkyrieParser#type}.
	 * @param ctx the parse tree
	 */
	void enterStringTypeSpec(ValkyrieParser.StringTypeSpecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringTypeSpec}
	 * labeled alternative in {@link ValkyrieParser#type}.
	 * @param ctx the parse tree
	 */
	void exitStringTypeSpec(ValkyrieParser.StringTypeSpecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BooleanTypeSpec}
	 * labeled alternative in {@link ValkyrieParser#type}.
	 * @param ctx the parse tree
	 */
	void enterBooleanTypeSpec(ValkyrieParser.BooleanTypeSpecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BooleanTypeSpec}
	 * labeled alternative in {@link ValkyrieParser#type}.
	 * @param ctx the parse tree
	 */
	void exitBooleanTypeSpec(ValkyrieParser.BooleanTypeSpecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VectorTypeSpec}
	 * labeled alternative in {@link ValkyrieParser#type}.
	 * @param ctx the parse tree
	 */
	void enterVectorTypeSpec(ValkyrieParser.VectorTypeSpecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VectorTypeSpec}
	 * labeled alternative in {@link ValkyrieParser#type}.
	 * @param ctx the parse tree
	 */
	void exitVectorTypeSpec(ValkyrieParser.VectorTypeSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(ValkyrieParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(ValkyrieParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code If}
	 * labeled alternative in {@link ValkyrieParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIf(ValkyrieParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code If}
	 * labeled alternative in {@link ValkyrieParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIf(ValkyrieParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code While}
	 * labeled alternative in {@link ValkyrieParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhile(ValkyrieParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code While}
	 * labeled alternative in {@link ValkyrieParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhile(ValkyrieParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link ValkyrieParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssign(ValkyrieParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link ValkyrieParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssign(ValkyrieParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElementAssign}
	 * labeled alternative in {@link ValkyrieParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterElementAssign(ValkyrieParser.ElementAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElementAssign}
	 * labeled alternative in {@link ValkyrieParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitElementAssign(ValkyrieParser.ElementAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CallStatement}
	 * labeled alternative in {@link ValkyrieParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCallStatement(ValkyrieParser.CallStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CallStatement}
	 * labeled alternative in {@link ValkyrieParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCallStatement(ValkyrieParser.CallStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Print}
	 * labeled alternative in {@link ValkyrieParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterPrint(ValkyrieParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Print}
	 * labeled alternative in {@link ValkyrieParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitPrint(ValkyrieParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Return}
	 * labeled alternative in {@link ValkyrieParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturn(ValkyrieParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Return}
	 * labeled alternative in {@link ValkyrieParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturn(ValkyrieParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockStatement}
	 * labeled alternative in {@link ValkyrieParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(ValkyrieParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockStatement}
	 * labeled alternative in {@link ValkyrieParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(ValkyrieParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Call}
	 * labeled alternative in {@link ValkyrieParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCall(ValkyrieParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Call}
	 * labeled alternative in {@link ValkyrieParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCall(ValkyrieParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Op}
	 * labeled alternative in {@link ValkyrieParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOp(ValkyrieParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Op}
	 * labeled alternative in {@link ValkyrieParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOp(ValkyrieParser.OpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Not}
	 * labeled alternative in {@link ValkyrieParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNot(ValkyrieParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link ValkyrieParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNot(ValkyrieParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link ValkyrieParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(ValkyrieParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link ValkyrieParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(ValkyrieParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Index}
	 * labeled alternative in {@link ValkyrieParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIndex(ValkyrieParser.IndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Index}
	 * labeled alternative in {@link ValkyrieParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIndex(ValkyrieParser.IndexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Negate}
	 * labeled alternative in {@link ValkyrieParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNegate(ValkyrieParser.NegateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Negate}
	 * labeled alternative in {@link ValkyrieParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNegate(ValkyrieParser.NegateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Atom}
	 * labeled alternative in {@link ValkyrieParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAtom(ValkyrieParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Atom}
	 * labeled alternative in {@link ValkyrieParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAtom(ValkyrieParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(ValkyrieParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(ValkyrieParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#call_expr}.
	 * @param ctx the parse tree
	 */
	void enterCall_expr(ValkyrieParser.Call_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#call_expr}.
	 * @param ctx the parse tree
	 */
	void exitCall_expr(ValkyrieParser.Call_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void enterExpr_list(ValkyrieParser.Expr_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void exitExpr_list(ValkyrieParser.Expr_listContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link ValkyrieParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(ValkyrieParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link ValkyrieParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(ValkyrieParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link ValkyrieParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterInteger(ValkyrieParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link ValkyrieParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitInteger(ValkyrieParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Float}
	 * labeled alternative in {@link ValkyrieParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterFloat(ValkyrieParser.FloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Float}
	 * labeled alternative in {@link ValkyrieParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitFloat(ValkyrieParser.FloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link ValkyrieParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterString(ValkyrieParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link ValkyrieParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitString(ValkyrieParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Vector}
	 * labeled alternative in {@link ValkyrieParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterVector(ValkyrieParser.VectorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Vector}
	 * labeled alternative in {@link ValkyrieParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitVector(ValkyrieParser.VectorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TrueLiteral}
	 * labeled alternative in {@link ValkyrieParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterTrueLiteral(ValkyrieParser.TrueLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TrueLiteral}
	 * labeled alternative in {@link ValkyrieParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitTrueLiteral(ValkyrieParser.TrueLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FalseLiteral}
	 * labeled alternative in {@link ValkyrieParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterFalseLiteral(ValkyrieParser.FalseLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FalseLiteral}
	 * labeled alternative in {@link ValkyrieParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitFalseLiteral(ValkyrieParser.FalseLiteralContext ctx);
}