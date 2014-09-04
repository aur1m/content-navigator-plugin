dojo.require("samplePluginDojo.CloseAccountActionModel");
dojo.require("samplePluginDojo.CloseAccountDialog");
function closeAccountFunction(repository, items) {
var getDateDialog = new samplePluginDojo.CloseAccountDialog;
getDateDialog.show(repository, items);
}