package io.github.jimmyfm.gwt.webapi.client.websocket;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class WebSocket extends EventTarget {

	@JsFunction
	public interface EventListener {
		public void call();
	}

	@JsFunction
	public interface CloseEventListener {
		public void call(Object closeEvent);
	}

	@JsFunction
	public interface MessageEventListener {
		public void call(Object messageEvent);
	}

	@JsProperty
	public static byte CONNECTING;

	@JsProperty
	public static byte OPEN;

	@JsProperty
	public static byte CLOSING;

	@JsProperty
	public static byte CLOSED;

	@JsProperty
	public CloseEventListener onclose;

	@JsProperty
	public EventListener onerror;

	@JsProperty
	public MessageEventListener onmessage;

	@JsProperty
	public EventListener onopen;

	@JsConstructor
	public WebSocket(String url) {
	}

	@JsMethod
	public native void send(String data);

	@JsMethod
	public native void close();

	@JsProperty
	public native String getUrl();
}