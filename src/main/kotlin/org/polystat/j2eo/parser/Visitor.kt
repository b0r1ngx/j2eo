package org.polystat.j2eo.parser

import org.polystat.j2eo.antlrParser.JavaParser
import org.polystat.j2eo.antlrParser.JavaParser.CompilationUnitContext
import org.polystat.j2eo.antlrParser.JavaParserBaseVisitor
import tree.Entity

class Visitor : JavaParserBaseVisitor<Entity>() {
    override fun visitCompilationUnit(ctx: CompilationUnitContext?): Entity = ctx!!.toCompilationUnit()
//        return SimpleCompilationUnit(
// //            ctx!!.packageDeclaration().qualifiedName().toCompoundName(),
//            ImportDeclarations(ArrayList(ctx!!.importDeclaration().map { it.toImportDeclaration() })),
//            TopLevelComponents(
//                TopLevelComponent(
//                    NormalClassDeclaration(
//                        Token(TokenCode.StringLiteral),
//                        null,
//                        Type(null),
//                        null,
//                        null,
//                    ).run { name = "Main"; this }
//                )
//            ),
//        )
//    }

    override fun visitPackageDeclaration(ctx: JavaParser.PackageDeclarationContext?): Entity = ctx!!.toPackage()

    //    override fun visitExpression(ctx: JavaParser.ExpressionContext?): Entity = ctx!!.toE
    override fun visitForControl(ctx: JavaParser.ForControlContext?): Entity {
        ctx?.enhancedForControl().apply { println("Found enhanced for control") }
        ctx?.forInit().apply { println("Found for init") }
        return tree.CompoundName("asdfasdfsdfasdfasdg")
    }

//    override fun visitClassOrInterfaceType(ctx: JavaParser.ClassOrInterfaceTypeContext?): Entity {
//        return super.visitClassOrInterfaceType(ctx)
//    }
//
//    override fun visitTypePrimitiveType(ctx: JavaParser.TypePrimitiveTypeContext?): Entity {
//        return super.visitTypePrimitiveType(ctx)
//    }
//
//    override fun visitTypeList(ctx: JavaParser.TypeListContext?): Entity {
//        return super.visitTypeList(ctx)
//    }
}
