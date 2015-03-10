/**
 * The MIT License (MIT)
 *
 * Copyright (C) 2015 Andreas Grimmer <a.grimmer@gmx.at>
 * Christoph Sperl <ch.sperl@gmx.at>
 * Stefan Wurzinger <swurzinger@gmx.at>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.apidesign.html.leaflet.api;

import net.java.html.js.JavaScriptBody;
import net.java.html.js.JavaScriptResource;

/**
 *
 * @author Stefan Wurzinger
 */
@JavaScriptResource("/org/apidesign/html/leaflet/api/leaflet-src.js")
public abstract class ImageOverlay extends ILayer {

    ImageOverlay(Object jsObj) {
        super(jsObj);
    }

    public ImageOverlay(String imageUrl, LatLngBounds bounds) {
        super(create(imageUrl, bounds.getJSObj(), new ImageOverlayOptions().getJSObj()));
    }

    public ImageOverlay(String imageUrl, LatLngBounds bounds, ImageOverlayOptions options) {
        super(create(imageUrl, bounds.getJSObj(), options.getJSObj()));
    }

    @JavaScriptBody(args = {"imageUrl", "bounds", "options"}, body
            = "return L.tileLayer(imageUrl, bounds, options);")
    private static native Object create(String imageUrl, Object bounds, Object options);

    // ------- Methods -------------------------------------------
    public ImageOverlay addTo(Map map) {
        addToInternal(jsObj, map.getJSObj());
        return this;
    }

    public ImageOverlay setOpacity(double opacity) {
        setOpacityInternal(jsObj, opacity);
        return this;
    }

    public ImageOverlay setUrl(String imageUrl) {
        setUrlInternal(jsObj, imageUrl);
        return this;
    }

    public ImageOverlay bringToFront() {
        bringToFrontInternal(jsObj);
        return this;
    }

    public ImageOverlay bringToBack() {
        bringToBackInternal(jsObj);
        return this;
    }

    @JavaScriptBody(args = {"jsObj", "map"}, body
            = "jsObj.addTo(map);")
    private static native void addToInternal(Object jsObj, Object map);

    @JavaScriptBody(args = {"jsObj", "opacity"}, body
            = "jsObj.setOpacity(opacity);")
    private static native void setOpacityInternal(Object jsObj, double opacity);

    @JavaScriptBody(args = {"jsObj", "imageUrl"}, body
            = "jsObj.setUrl(imageUrl);")
    private static native void setUrlInternal(Object jsObj, String imageUrl);

    @JavaScriptBody(args = {"jsObj"}, body
            = "jsObj.bringToFront();")
    private static native void bringToFrontInternal(Object jsObj);

    @JavaScriptBody(args = {"jsObj"}, body
            = "jsObj.bringToBack();")
    private static native void bringToBackInternal(Object jsObj);

    // ------- Popup methods -------------------------------------------
    public ImageOverlay bindPopup(String html) {
        bindPopup1sInternal(jsObj, html);
        return this;
    }

    public ImageOverlay bindPopup(Popup popup) {
        bindPopup1pInternal(jsObj, popup.getJSObj());
        return this;
    }

    public ImageOverlay bindPopup(Popup popup, PopupOptions options) {
        bindPopup2Internal(jsObj, popup.getJSObj(), options.getJSObj());
        return this;
    }

    public ImageOverlay unbindPopup() {
        unbindPopupInternal(jsObj);
        return this;
    }

    public ImageOverlay openPopup() {
        openPopupInternal(jsObj);
        return this;
    }

    public ImageOverlay closePopup() {
        closePopupInternal(jsObj);
        return this;
    }

    @JavaScriptBody(args = {"jsObj", "html"}, body
            = "jsObj.bindPopup(html);")
    private static native void bindPopup1sInternal(Object jsObj, String html);

    @JavaScriptBody(args = {"jsObj", "popup"}, body
            = "jsObj.bindPopup(popup);")
    private static native void bindPopup1pInternal(Object jsObj, Object popup);

    @JavaScriptBody(args = {"jsObj", "popup", "options"}, body
            = "jsObj.bindPopup(popup, options);")
    private static native void bindPopup2Internal(Object jsObj, Object popup, Object options);

    @JavaScriptBody(args = {"jsObj"}, body
            = "jsObj.unbindPopup();")
    private static native void unbindPopupInternal(Object jsObj);

    @JavaScriptBody(args = {"jsObj"}, body
            = "jsObj.openPopup();")
    private static native void openPopupInternal(Object jsObj);

    @JavaScriptBody(args = {"jsObj"}, body
            = "jsObj.closePopup();")
    private static native void closePopupInternal(Object jsObj);

}