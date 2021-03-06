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
package net.java.html.leaflet;

import net.java.html.js.JavaScriptBody;



/**
 * Rarely used by some commercial tile providers. Uses Elliptical Mercator
 * projection.
 */
final class EPSG3395 extends ICRS {
    private static final EPSG3395 instance = new EPSG3395();
    static {
        Options.initJS();
        ICRS.registerCRS("EPSG3395", instance);
    }

    /**
     * Returns the Instance of EPSG3395 CRS
     *
     * @return instance of EPSG3395 CRS
     */
    static EPSG3395 get() {
        return instance;
    }

    private EPSG3395() {
        super(getCRSInternal());
    }

    @JavaScriptBody(args = {}, body = "return L.CRS.EPSG3395;")
    private static native Object getCRSInternal();
}
