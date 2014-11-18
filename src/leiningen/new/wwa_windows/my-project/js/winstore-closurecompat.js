(function (global) {
    function wrapUnsafeFunction(obj, prop) {
        var actual = obj[prop];
        var wrapper = function () {
            var context = this;
            var args = arguments;
            return MSApp.execUnsafeLocalFunction(function () {
                return actual.apply(context, args);
            });
        };
        Object.defineProperty(obj, prop, {
            get: function () {
                return wrapper;
            },
            set: function (v) {
                actual = v;
            }
        });
    }

    global.goog = {};
    wrapUnsafeFunction(goog, "writeScriptTag_");
})(this);