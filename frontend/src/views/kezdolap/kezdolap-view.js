import { PolymerElement } from '@polymer/polymer/polymer-element.js';
import '../../../styles/shared-styles.js';
import { html } from '@polymer/polymer/lib/utils/html-tag.js';
class KezdolapView extends PolymerElement {
  static get template() {
    return html`
    <style include="shared-styles">
      :host {
        width: 100%;
        -webkit-overflow-scrolling: touch;
        overflow: auto;
      }

    </style>


`;
  }

  static get is() {
    return 'kezdolap-view';
  }

  // This method is overridden to measure the page load performance and can be safely removed
  // if there is no need for that.
  ready() {
    super.ready();
    this._chartsLoaded = new Promise((resolve, reject) => {
      // save the 'resolve' callback to trigger it later from the server
      this._chartsLoadedResolve = () => {
        resolve();
      };
    });




  }
}

window.customElements.define(KezdolapView.is, KezdolapView);
