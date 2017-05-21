package io.github.jimmyfm.gwt.promises.client;

public class EntryPoint implements com.google.gwt.core.client.EntryPoint {

	@Override
	public void onModuleLoad() {

		Promise p1 = new Promise((res, rej) -> {
			res.accept("p1");
		});

		Promise p2 = new Promise((res, rej) -> {
			res.accept("p2");
		});

		Promise p3 = new Promise((res, rej) -> {
			res.accept("p3");
		});

		Promise.all(new Promise[] { p1, p2, p3 }).then((t) -> log("Then", t)).error((t) -> log("Error", t));
	}

	public final static native void log(Object... o) /*-{
		console.log(o);
	}-*/;
}