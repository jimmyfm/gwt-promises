package io.github.jimmyfm.gwt.promises.client.ws;

import com.google.gwt.core.client.JavaScriptObject;

import jsinterop.annotations.JsFunction;

@JsFunction
public interface EventListener{
	
	public JavaScriptObject call(JavaScriptObject event);

}