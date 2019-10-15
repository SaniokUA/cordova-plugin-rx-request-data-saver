module.exports = {
    saveData: function (action, data, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "RequestDataSaver", "requestDataSaver", [data]);
    },

    changeSchedule: function (data, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "RequestDataSaver", "changeSchedule", [data]);
    }
};