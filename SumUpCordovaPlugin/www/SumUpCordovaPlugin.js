var exec = require('cordova/exec');

exports.sumupLogin = function (arg0, success, error) {
    exec(success, error, 'SumUpCordovaPlugin', 'sumupLogin', [arg0]);
};
