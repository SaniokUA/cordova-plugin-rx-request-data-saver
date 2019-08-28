module.exports = {
    saveData: function (action, data, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "RequestDataSaver", "requestDataSaver", [data]);
    },

    changeSchedule: function (data, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "RequestDataSaver", "changeSchedule", [data]);
    }
};

// module.exports = {
//     saveData: function (action, data, successCallback, errorCallback) {
//         cordova.exec(action, [data], successCallback, errorCallback);
//         console.log(" saveData action", action);
//         console.log(" saveData data", data);
//     }
// };