package com.liulangf.asm;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import clojure.asm.AnnotationVisitor;
import clojure.asm.ClassWriter;
import clojure.asm.FieldVisitor;
import clojure.asm.Label;
import clojure.asm.MethodVisitor;
import clojure.asm.Opcodes;

public class ForLabelDump implements Opcodes {

	public static byte[] dump() throws Exception {
		ClassWriter cw = new ClassWriter(0);
		FieldVisitor fv;
		MethodVisitor mv;
		AnnotationVisitor av0;
		cw.visit(V1_6, ACC_PUBLIC + ACC_SUPER, "com/liulangf/asm/ForLabelDump",
				null, "java/lang/Object", null);

		cw.visitSource("ForLabelDump.java", null);

		{
			mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			Label l0 = new Label();
			mv.visitLabel(l0);
			mv.visitLineNumber(3, l0);
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>",
					"()V");
			mv.visitInsn(RETURN);
			Label l1 = new Label();
			mv.visitLabel(l1);
			mv.visitLocalVariable("this", "Lcom/liulangf/asm/ForLabelDump;",
					null, l0, l1, 0);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		
		{
			mv = cw.visitMethod(ACC_PUBLIC, "for100", "()V", null, null);
			mv.visitCode();
			Label l0 = new Label();
			mv.visitLabel(l0);
			mv.visitLineNumber(7, l0);
			mv.visitInsn(ICONST_0);
			mv.visitVarInsn(ISTORE, 1);
			Label l1 = new Label();
			mv.visitLabel(l1);
			Label l2 = new Label();
			mv.visitJumpInsn(GOTO, l2);
			Label l3 = new Label();
			mv.visitLabel(l3);
			mv.visitFrame(Opcodes.F_APPEND,1, new Object[] {Opcodes.INTEGER}, 0, null);
			mv.visitIincInsn(1, 1);
			mv.visitLabel(l2);
			mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
			mv.visitVarInsn(ILOAD, 1);
			mv.visitIntInsn(BIPUSH, 100);
			mv.visitJumpInsn(IF_ICMPLT, l3);
			Label l4 = new Label();
			mv.visitLabel(l4);
			mv.visitLineNumber(10, l4);
			mv.visitInsn(RETURN);
			Label l5 = new Label();
			mv.visitLabel(l5);
			mv.visitLocalVariable("this", "Lcom/liulangf/asm/ForLabel;", null, l0, l5, 0);
			mv.visitLocalVariable("i", "I", null, l1, l4, 1);
			mv.visitMaxs(2, 2);
			mv.visitEnd();
			}
			cw.visitEnd();

		
		cw.visitEnd();

		return cw.toByteArray();
	}
	
	public static void main(String...args) throws FileNotFoundException, IOException, Exception {
		IOUtils.write(dump(), new FileOutputStream("ForLabelDump.class"));
	}

}
