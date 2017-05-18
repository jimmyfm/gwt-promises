package io.github.jimmyfm.gwt.promises.client;

import io.github.jimmyfm.gwt.promises.client.Promise.ConstructorParam;
import io.github.jimmyfm.gwt.promises.client.Promise.FunctionParam;

public class EntryPoint implements com.google.gwt.core.client.EntryPoint {

	@Override
	public void onModuleLoad() {

		ConstructorParam parameters = new ConstructorParam() {

			@Override
			public void exec(FunctionParam resolve, FunctionParam reject) {
				if (Math.round(Math.random()) == 0)
					resolve.exec("culo");
				else
					reject.exec("culo2");
			}
		};
		Promise p = new Promise(parameters);
		p.then(new FunctionParam() {

			@Override
			public void exec(Object o) {
				log("Then", o);
			}
		});
		p.error(new FunctionParam() {

			@Override
			public void exec(Object o) {
				log("Error", o);
			}
		});
		log(p);
	}

	public final static native void log(Object... o) /*-{
		console.log(o);
	}-*/;
}