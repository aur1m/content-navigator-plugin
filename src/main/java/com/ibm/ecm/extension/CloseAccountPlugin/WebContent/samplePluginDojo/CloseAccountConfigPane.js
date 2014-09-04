dojo.provide("samplePluginDojo.CloseAccountConfigPane");
dojo.require("ecm.widget.admin.PluginConfigurationPane");
dojo.require("dijit._Templated");
/**
 * @name samplePluginDojo.CloseAccountConfigPane
 * @class
 * @augments ecm.widget.admin.PluginConfigurationPane
 */
dojo.declare("samplePluginDojo.CloseAccountConfigPane", [
    ecm.widget.admin.PluginConfigurationPane, dijit._Templated ], {
    /** @lends samplePluginDojo.CloseAccountConfigPane.prototype */
    templateString: dojo.cache("samplePluginDojo",
        "templates/CloseAccountConfigPane.html"),
    widgetsInTemplate: true,
    postCreate: function () {
        this.inherited(arguments);
    },
    load: function (callback) {
        if (this.configurationString) {
            var jsonConfig = eval('(' + this.configurationString + ')');
            var checkboxValue = jsonConfig.configuration.value;
            if (checkboxValue = "on")
                this.checkboxField.set('value', "on");
            else
                this.checkboxField.set('value', "off");
        }
    },
    _onParamChange: function () {
        var configString = {
            name: "checkboxField",
            value: this.checkboxField.get('value')
        };
        var configJson = {"configuration": configString};
        this.configurationString = JSON.stringify(configJson);
        this.onSaveNeeded(true);
    },
    validate: function () {
        return true;
    }
});