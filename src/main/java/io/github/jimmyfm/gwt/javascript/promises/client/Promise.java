package io.github.jimmyfm.gwt.javascript.promises.client;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * <p>
 * The Promise object represents the eventual completion (or failure) of an asynchronous operation, and its resulting
 * value.
 * </p>
 * <p>
 * A promise is in one of three different states:
 * </p>
 * <ul>
 * <li>pending - The initial state of a promise.</li>
 * <li>fulfilled - The state of a promise representing a successful operation.</li>
 * <li>rejected - The state of a promise representing a failed operation.</li>
 * </ul>
 * <p>
 * Once a promise is fulfilled or rejected, it is immutable (i.e. it can never change again).
 * </p>
 *
 * @see <a href= "https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise">
 *      https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise</a>
 * @author jimmyfm
 */

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class Promise
{

	@JsFunction
	public interface FunctionParam
	{
		void accept(final Object o);
	}

	/**
	 * A function that is passed with the arguments resolve and reject. The executor function is executed immediately by
	 * the Promise implementation, passing resolve and reject functions (the executor is called before the Promise
	 * constructor even returns the created object). The resolve and reject functions, when called, resolve or reject
	 * the promise, respectively. The executor normally initiates some asynchronous work, and then, once that completes,
	 * either calls the resolve function to resolve the promise or else rejects it if an error occurred. If an error is
	 * thrown in the executor function, the promise is rejected. The return value of the executor is ignored.
	 */
	@JsFunction
	public interface ExecutorFunction
	{
		void exec(final FunctionParam resolve, final FunctionParam reject);
	}

	@JsConstructor
	public Promise(final ExecutorFunction executor)
	{
	}

	/**
	 * The then() method returns a Promise. It takes up to two arguments: callback functions for the success and failure
	 * cases of the Promise. <br />
	 * Note: If both arguments are omitted, or are provided non-functions, a new Promise is created with no additional
	 * handlers, simply adopting the final state of the Promise that then is called on. If the first argument is omitted
	 * or provided a non-function, the new Promise that is created simply adopts the fulfillment state of the Promise
	 * that then is called on (if it becomes fulfilled). If the second argument is omitted or provided a non-function,
	 * the new Promise that is created simply adopts the rejection state of the Promise that then is called on (if it
	 * becomes rejected).
	 *
	 * @param onFulfilled
	 *            A Function called when the Promise is fulfilled. This function has one argument, the fulfillment
	 *            value.
	 * @return A Promise which rejects or resolves with the value returned by the input function onFulfilled or
	 *         onRejected. <br />
	 *         It returns a rejected Promise if the input function throws an error, or the input function returns a
	 *         rejected Promise. <br />
	 *         A resolved Promise is returned if the input function returns a value, or the input function returns a
	 *         resolved Promise.
	 *
	 */
	public native final Promise then(final FunctionParam onFulfilled);

	/**
	 * The then() method returns a Promise. It takes up to two arguments: callback functions for the success and failure
	 * cases of the Promise. <br />
	 * Note: If both arguments are omitted, or are provided non-functions, a new Promise is created with no additional
	 * handlers, simply adopting the final state of the Promise that then is called on. If the first argument is omitted
	 * or provided a non-function, the new Promise that is created simply adopts the fulfillment state of the Promise
	 * that then is called on (if it becomes fulfilled). If the second argument is omitted or provided a non-function,
	 * the new Promise that is created simply adopts the rejection state of the Promise that then is called on (if it
	 * becomes rejected).
	 *
	 * @param onFulfilled
	 *            A Function called when the Promise is fulfilled. This function has one argument, the fulfillment
	 *            value.
	 * @param onRejected
	 *            A Function called when the Promise is rejected. This function has one argument, the rejection reason.
	 * @return A Promise which rejects or resolves with the value returned by the input function onFulfilled or
	 *         onRejected. <br />
	 *         It returns a rejected Promise if the input function throws an error, or the input function returns a
	 *         rejected Promise. <br />
	 *         A resolved Promise is returned if the input function returns a value, or the input function returns a
	 *         resolved Promise.
	 */
	public native final Promise then(final FunctionParam onFulfilled, final FunctionParam onRejected);

	/**
	 * The catch() method returns a Promise and deals with rejected cases only. It behaves the same as calling
	 * Promise.prototype.then(undefined, onRejected). <br />
	 * The Promise returned by catch() is rejected if onRejected throws an error or returns a Promise which is itself
	 * rejected; otherwise, it is resolved.
	 *
	 * @param onRejected
	 *            A Function called when the Promise is rejected. This function has one argument: reason, The rejection
	 *            reason.
	 * @return A Promise.
	 */
	@JsMethod(name = "catch")
	public native final Promise error(final FunctionParam onRejected);

	/**
	 * Returns a promise that either fulfills when all of the promises in the iterable argument have fulfilled or
	 * rejects as soon as one of the promises in the iterable argument rejects. If the returned promise fulfills, it is
	 * fulfilled with an array of the values from the fulfilled promises in the same order as defined in the iterable.
	 * If the returned promise rejects, it is rejected with the reason from the first promise in the iterable that
	 * rejected. This method can be useful for aggregating results of multiple promises.
	 *
	 * @param promises
	 *            An iterable object (such as an Array) of promises.
	 * @return A Promise that resolves when all of the promises in the given iterable have resolved, or rejects if any
	 *         of the promises rejects.
	 */
	@JsMethod
	public native final static Promise all(final Promise[] promises);

	/**
	 * Returns a promise that fulfills or rejects as soon as one of the promises in the iterable fulfills or rejects,
	 * with the value or reason from that promise.
	 *
	 * @param promises
	 *            An iterable object, such as an Array. See iterable.
	 * @return A Promise that resolves or rejects as soon as one of the promises in the given iterable resolves or
	 *         rejects.
	 */
	@JsMethod
	public native final static Promise race(final Promise[] promises);

	/**
	 * Returns a Promise object that is rejected with the given reason.
	 */
	@JsMethod
	public native final static Promise reject(final Object reason);

	/**
	 * The Promise.resolve(value) method returns a Promise object that is resolved with the given value. If the value is
	 * a thenable (i.e. has a "then" method), the returned promise will "follow" that thenable, adopting its eventual
	 * state; otherwise the returned promise will be fulfilled with the value.
	 *
	 * @param value
	 *            Argument to be resolved by this Promise. Can also be a Promise or a thenable to resolve.
	 * @return A Promise that is resolved with the given value.
	 */
	@JsMethod
	public native final static Promise resolve(final Object value);
}