package Analyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class Transformer implements IAnnotationTransformer {
	public void transform(ITestAnnotation annotation,Class testClass,Constructor testConstructor,Method testMethod) {
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}
//	public static void main(String[] args)throws Exception{
//		Transformer t=new Transformer();
//		t.transform(null, null, null, null);
//	}

}
