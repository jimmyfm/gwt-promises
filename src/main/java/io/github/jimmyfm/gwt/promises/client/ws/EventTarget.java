package io.github.jimmyfm.gwt.promises.client.ws;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class EventTarget {

	public native void addEventListener(String type, EventListener listener);

}