package io.github.jimmyfm.gwt.examples.promises.client;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

import io.github.jimmyfm.gwt.promises.client.Promise;

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

		Button catch1 = new Button("catch1");
		catch1.addClickHandler(e -> catch1());
		RootPanel.get().add(catch1);
	}

	/**
	 * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise/catch
	 * 
	 * XXX We need to manage better exceptions thrown inside promises and the possibility to return values or promises,
	 * this example shows clearly what we are lacking
	 */
	private void catch1() {
		Promise p1 = new Promise((resolve, reject) -> {
			resolve.accept("Success");
		});

		p1.then((value) -> {
			log(value); // "Success!"
			throw new RuntimeException("oh, no!");
		}).error((e) -> {
			log(e); // "oh, no!"
		}).then((v) -> {
			log("after a catch the chain is restored");
		}, (v) -> {
			log("Not fired due to the catch");
		});

		// The following behaves the same as above
		// p1.then((value) -> {
		// log(value); // "Success!"
		// // XXX return Promise.reject("oh, no!");
		// }).error((e) -> {
		// log(e); // "oh, no!"
		// }).then((v) -> {
		// log("after a catch the chain is restored");
		// }, (v) -> {
		// log("Not fired due to the catch");
		// });
	}

	public final static native void log(Object... o) /*-{
		console.log(o);
	}-*/;
}