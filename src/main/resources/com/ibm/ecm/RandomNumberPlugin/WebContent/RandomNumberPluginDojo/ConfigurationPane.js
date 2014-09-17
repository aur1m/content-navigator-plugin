define([
		"dojo/_base/declare",
		"dijit/_TemplatedMixin",
		"dijit/_WidgetsInTemplateMixin",
		"ecm/widget/admin/PluginConfigurationPane",
		"dojo/text!./templates/ConfigurationPane.html"
	],
	function(declare, _TemplatedMixin, _WidgetsInTemplateMixin, PluginConfigurationPane, template) {

		/**
		 * @name RandomNumberPluginDojo.ConfigurationPane
		 * @class Provides a configuration panel for your plugin.
		 * @augments ecm.widget.admin.PluginConfigurationPane
		 */
		return declare("RandomNumberPluginDojo.ConfigurationPane", [ PluginConfigurationPane, _TemplatedMixin, _WidgetsInTemplateMixin], {
		/** @lends RandomNumberPluginDojo.ConfigurationPane.prototype */

		templateString: template,
		widgetsInTemplate: true,

        /**
         * Called by administration to load the configuration settings into the interface.
          * @param callback
         */
		load: function(onComplete) {
			//
		},
        /**
         * Called by administration to save the configuration settings displayed by this interface.
         * @param onComplete
         */
        save: function(onComplete) {

        },

        /**
         * Called by administration to validate the current values in the plug-in configuration interface.
         * @return true if validation is success, else - false.
         */
		validate: function() {
            return true;
		}
	});
});
