dojo.provide("samplePluginDojo.CloseAccountDialog");
dojo.require("ecm.model.Desktop");
dojo.require("ecm.MessagesMixin");
dojo.require("ecm.widget.dialog.BaseDialog");
dojo.require("ecm.widget.DatePicker");
dojo.require("dijit.form.Button");

dojo.declare("samplePluginDojo.CloseAccountDialog", [ ecm.widget.dialog.BaseDialog ], {
widgetsInTemplate: true,
_closeDate: null,
_items: null,
_repository: null,
contentString: dojo.cache("samplePluginDojo", "templates/CloseAccountDialog.html"),

postCreate: function() {
	this.inherited(arguments);
	this.setTitle("Close Account");
	this.setIntroText("Enter the date when the account associated with the documents was closed.");
	this.okButton = this.addButton("Ok", "_onClickOk", false, true);
},
show: function(repository, items) {
	this._repository = repository;
	this._items = items;
	this.inherited("show", []);
},
_onClickOk: function() {
	var params = new Object();
	params.server = "SED";
	params.serverType = "p8";
	params.ndocs = this._items.length;
	for (var i in this._items) {
		params["docID"+i] = this._items[i].id;
	}
	var dateTimeStr= this._closeDateInput.value;
	params.date = dojo.date.locale.format(dateTimeStr, {selector: "date",datePattern: "yyyy-M-d"});
	ecm.model.Request.invokeSynchronousPluginService("CloseAccountPlugin", 
			"CloseAccountService", params, function(response) {});
	this.onCancel();
	}
});