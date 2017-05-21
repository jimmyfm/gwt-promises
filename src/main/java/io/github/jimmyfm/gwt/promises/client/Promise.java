package io.github.jimmyfm.gwt.promises.client;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class Promise {

	@JsFunction
	public interface FunctionParam {
		void accept(final Object o);
	}

	@JsFunction
	public interface ConstructorParam {
		void exec(final FunctionParam resolve, final FunctionParam reject);
	}

	@JsConstructor
	public Promise(final ConstructorParam parameters) {
	}

	public native final Promise then(final FunctionParam f);

	@JsMethod(name = "catch")
	public native final Promise error(final FunctionParam f);

	@JsMethod
	public native final static Promise all(final Promise[] promises);
}