package io.github.jimmyfm.gwt.promises.client;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "console")
public class Console {

	private Console() {
	}

	public native static final void log(Object... obj);

	public native static final void info(Object... obj);

	public native static final void trace(Object... obj);

	public native static final void warn(Object... obj);

}