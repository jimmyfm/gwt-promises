package io.github.jimmyfm.gwt.webapi.client.notification;

import io.github.jimmyfm.gwt.javascript.promises.client.Promise;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class Notification {

	@JsConstructor
	public Notification(String title) {
	}

	@JsConstructor
	public Notification(String title, NotificationOptions options) {
	}

	@JsMethod
	public static final native Promise requestPermission();
}