package examples.promises.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

import io.github.jimmyfm.gwt.webapi.client.Console;
import io.github.jimmyfm.gwt.webapi.client.websocket.EventListener;
import io.github.jimmyfm.gwt.webapi.client.websocket.WebSocket;

public class EntryPoint implements com.google.gwt.core.client.EntryPoint {

	@Override
	public void onModuleLoad() {

		// Console.log(23, "23,", this);
		// Console.warn(23, "23,", this);
		// Console.trace(23, "23,", this);

		// Notification.requestPermission();
		// NotificationOptions opt = new NotificationOptions();
		// opt.setBody("asdasda");
		// Console.log(opt);
		// Notification n = new Notification("asd", opt);
		// Console.log(n);

		final WebSocket socket = new WebSocket("ws://echo.websocket.org");

		socket.onmessage = Console::log;
		socket.onclose = Console::log;
		socket.onerror = () -> GWT.log("socket error");
		socket.onopen = () -> {
			GWT.log("socket open");
			socket.send("asd");
		};

		socket.addEventListener("message", new EventListener() {

			@Override
			public JavaScriptObject call(JavaScriptObject event) {
				Console.log("attached", event);
				return null;
			}
		});

		Button btn = new Button("Close", (ClickHandler) (e) -> socket.close());
		RootPanel.get().add(btn);
	}
}