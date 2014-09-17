define([
    "dojo/_base/declare",
    "ecm/model/Action",
    "ecm/model/Request",
    "ecm/widget/dialog/MessageDialog"
], function (declare, Action, Request, MessageDialog) {
    return declare("RandomNumberPluginDojo/RandomNumberActionModel", [ Action ], {
        dossierFolderClass: null,
        isEnabled: function (repository, listType, items, teamspace, resultSet) {
            var enabled = this.inherited(arguments);
            if (items && items[0].isFolder && items[0].getContentClass) {
                return enabled && items[0].isFolder();
            }
            return false;

        },
        isVisible: function (repository, listType) {
            return this.inherited(arguments);
        },
        performAction: function (repository, itemList, callback, teamspace, resultSet, parameterMap) {
            this.logEntry("performAction", "items=" + itemList);

            var messageDialog = new MessageDialog({
                text: "Hello!"
            });
            messageDialog.show();
            this.logExit("performAction");
        }
    });
});