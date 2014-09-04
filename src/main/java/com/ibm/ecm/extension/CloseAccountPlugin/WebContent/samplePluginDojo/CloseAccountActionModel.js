dojo.provide("samplePluginDojo.CloseAccountActionModel");
dojo.require("ecm.model.Action");
dojo.declare("samplePluginDojo.CloseAccountActionModel", [ecm.model.Action ], {
	isEnabled: function(repository, listType, items, workspace, resultSet) {
		var enabled = true;
		for (var i in items) {
			var docclass = items[i].getContentClass();
			var docclassname = docclass.id;
			if (docclassname != "InsuranceDocuments")
				enabled = false;
		}
		return enabled;
},

isVisible: function(repository, listType) {
	return true;
}
});