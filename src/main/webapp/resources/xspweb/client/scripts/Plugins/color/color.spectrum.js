(function(j, e, g) {
    var p = {
            beforeShow: b,
            move: b,
            change: b,
            show: b,
            hide: b,
            color: false,
            flat: false,
            showInput: false,
            allowEmpty: false,
            showButtons: true,
            clickoutFiresChange: false,
            showInitial: false,
            showPalette: false,
            showPaletteOnly: false,
            showSelectionPalette: true,
            localStorageKey: false,
            appendTo: "body",
            maxSelectionSize: 7,
            cancelText: "cancel",
            chooseText: "choose",
            clearText: "Clear Color Selection",
            preferredFormat: false,
            className: "",
            containerClassName: "",
            replacerClassName: "",
            showAlpha: false,
            theme: "sp-light",
            palette: [
                ["#ffffff", "#000000", "#ff0000", "#ff8000", "#ffff00", "#008000", "#0000ff", "#4b0082", "#9400d3"]
            ],
            selectionPalette: [],
            disabled: false
        },
        d = [],
        k = !! /msie/i.exec(j.navigator.userAgent),
        n = (function() {
            function x(B, A) {
                return !!~ ("" + B).indexOf(A)
            }
            var z = document.createElement("div");
            var y = z.style;
            y.cssText = "background-color:rgba(0,0,0,.5)";
            return x(y.backgroundColor, "rgba") || x(y.backgroundColor, "hsla")
        })(),
        o = (function() {
            var x = e("<input type='color' value='!' />")[0];
            return x.type === "color" && x.value !== "!"
        })(),
        t = ["<div class='sp-replacer'>", "<div class='sp-preview'><div class='sp-preview-inner'></div></div>", "<div class='sp-dd'>&#9660;</div>", "</div>"].join(""),
        s = (function() {
            var x = "";
            if (k) {
                for (var y = 1; y <= 6; y++) {
                    x += "<div class='sp-" + y + "'></div>"
                }
            }
            return ["<div class='sp-container sp-hidden sv' style='z-index: 999'>", "<div class='custom-tab slide-tab'>", "<ul class='fix'>", "<li data-role='base' class='active' data-toggle='tab'><a href='javascript:;'>基本颜色</a></li>", "<li data-role='other' data-toggle='tab'><a href='javascript:;'>自定义</a></li>", "</ul>", "<div class='slider' style='height: 25px'></div>", "</div>", "<div>", "<div class='sp-palette-container' data-base='1'>", "<div class='sp-palette sp-thumb sp-cf'></div>", "<div class='custom-selection-separate'></div>", "</div>", "<div class='sp-picker-container custom-hide' data-other='1'>", "<div class='sp-top sp-cf'>", "<div class='sp-fill'></div>", "<div class='sp-top-inner'>", "<div class='sp-color'>", "<div class='sp-sat'>", "<div class='sp-val'>", "<div class='sp-dragger'></div>", "</div>", "</div>", "</div>", "<div class='sp-clear sp-clear-display'>", "</div>", "<div class='sp-hue'>", "<div class='sp-slider'></div>", x, "</div>", "</div>", "<div class='sp-alpha'><div class='sp-alpha-inner'><div class='sp-alpha-handle'></div></div></div>", "</div>", "<div class='sp-input-container sp-cf'>", "<input class='sp-input' type='text' spellcheck='false'  />", "</div>", "<div class='sp-initial sp-thumb sp-cf'></div>", "<div class='sp-button-container sp-cf'>", "<a class='sp-cancel' href='#'></a>", "<button type='button' class='sp-choose'></button>", "</div>", "</div>", "</div>", "</div>"].join("")
        })();

    function w(y, A, E, H) {
        var C = [];
        for (var B = 0; B < y.length; B++) {
            var D = y[B];
            if (D) {
                var x = tinycolor(D);
                var G = x.toHsl().l < 0.5 ? "sp-thumb-el sp-thumb-dark" : "sp-thumb-el sp-thumb-light";
                G += (tinycolor.equals(A, D)) ? " sp-thumb-active" : "";
                var F = x.toString(H || "rgb");
                var z = n ? ("background-color:" + x.toRgbString()) : "filter:" + x.toFilter();
                C.push('<span title="' + F + '" data-color="' + x.toRgbString() + '" class="' + G + '"><span class="sp-thumb-inner" style="' + z + ';" /></span>')
            } else {
                var I = "sp-clear-display";
                C.push('<span title="No Color Selected" data-color="" style="background-color:transparent;" class="' + I + '"></span>')
            }
        }
        return "<div class='sp-cf " + E + "'>" + C.join("") + "</div>"
    }
    function r() {
        for (var x = 0; x < d.length; x++) {
            if (d[x]) {
                d[x].hide()
            }
        }
    }
    function q(z, x) {
        var y = e.extend({}, p, z);
        y.callbacks = {
            move: v(y.move, x),
            change: v(y.change, x),
            show: v(y.show, x),
            hide: v(y.hide, x),
            beforeShow: v(y.beforeShow, x)
        };
        return y
    }
    function u(a8, aj) {
        var a7 = q(aj, a8),
            a3 = a7.flat,
            Z = a7.showSelectionPalette,
            y = a7.localStorageKey,
            al = a7.theme,
            U = a7.callbacks,
            H = f(af, 10),
            R = false,
            aM = 0,
            ah = 0,
            aN = 0,
            az = 0,
            O = 0,
            ay = 0,
            aX = 0,
            aq = 0,
            ab = 0,
            S = 0,
            aC = 0,
            aY = 1,
            ak = [],
            am = [],
            a5 = {},
            aI = a7.selectionPalette.slice(0),
            aH = a7.maxSelectionSize,
            z = "sp-dragging",
            J = null;
        var aa = a8.ownerDocument,
            Q = aa.body,
            G = e(a8),
            aV = false,
            aO = e(s, aa).addClass(al),
            L = aO.find(".sp-color"),
            aL = aO.find(".sp-dragger"),
            P = aO.find(".sp-hue"),
            a2 = aO.find(".sp-slider"),
            aE = aO.find(".sp-alpha-inner"),
            ac = aO.find(".sp-alpha"),
            aF = aO.find(".sp-alpha-handle"),
            N = aO.find(".sp-input"),
            T = aO.find(".sp-palette"),
            a6 = aO.find(".sp-initial"),
            aw = aO.find(".custom-tab"),
            A = aO.find(".sp-palette-container"),
            a0 = aO.find(".sp-picker-container"),
            ap = aO.find(".sp-cancel"),
            an = aO.find(".sp-clear"),
            K = aO.find(".sp-choose"),
            V = G.is("input"),
            E = V && o && G.attr("type") === "color",
            aB = V && !a3,
            aT = (aB) ? e(t).addClass(al).addClass(a7.className).addClass(a7.replacerClassName) : e([]),
            av = (aB) ? aT : G,
            M = aT.find(".sp-preview-inner"),
            W = a7.color || (V && G.val()),
            aP = false,
            Y = a7.preferredFormat,
            at = Y,
            I = !a7.showButtons || a7.clickoutFiresChange,
            F = !W,
            a4 = a7.allowEmpty && !E;

        function x() {
            if (a7.showPaletteOnly) {
                a7.showPalette = true
            }
            if (a7.palette) {
                ak = a7.palette.slice(0);
                am = e.isArray(ak[0]) ? ak : [ak];
                a5 = {};
                for (var bc = 0; bc < am.length; bc++) {
                    for (var bb = 0; bb < am[bc].length; bb++) {
                        var ba = tinycolor(am[bc][bb]).toRgbString();
                        a5[ba] = true
                    }
                }
            }
            aO.toggleClass("sp-flat", a3);
            aO.toggleClass("sp-input-disabled", !a7.showInput);
            aO.toggleClass("sp-alpha-enabled", a7.showAlpha);
            aO.toggleClass("sp-clear-enabled", a4);
            aO.toggleClass("sp-buttons-disabled", !a7.showButtons);
            aO.toggleClass("sp-palette-disabled", !a7.showPalette);
            aO.toggleClass("sp-palette-only", a7.showPaletteOnly);
            aO.toggleClass("sp-initial-disabled", !a7.showInitial);
            aO.addClass(a7.className).addClass(a7.containerClassName);
            af()
        }
        function aJ() {
            if (k) {
                aO.find("*:not(input)").attr("unselectable", "on")
            }
            x();
            if (aB) {
                G.after(aT).hide()
            }
            if (!a4) {
                an.hide()
            }
            if (a3) {
                G.after(aO).hide()
            } else {
                var bc = a7.appendTo === "parent" ? G.parent() : e(a7.appendTo);
                if (bc.length !== 1) {
                    bc = e("body")
                }
                bc.append(aO)
            }
            aQ();
            av.bind("click.spectrum touchstart.spectrum", function(bd) {
                if (!aV) {
                    ax()
                }
                bd.stopPropagation();
                if (!e(bd.target).is("input")) {
                    bd.preventDefault()
                }
            });
            if (G.is(":disabled") || (a7.disabled === true)) {
                X()
            }
            aO.click(m);
            N.change(aR);
            N.bind("paste", function() {
                setTimeout(aR, 1)
            });
            N.keydown(function(bd) {
                if (bd.keyCode == 13) {
                    aR()
                }
            });
            ap.text(a7.cancelText);
            ap.bind("click.spectrum", function(bd) {
                bd.stopPropagation();
                bd.preventDefault();
                aG("cancel")
            });
            an.attr("title", a7.clearText);
            an.bind("click.spectrum", function(bd) {
                bd.stopPropagation();
                bd.preventDefault();
                F = true;
                aK();
                if (a3) {
                    ao(true)
                }
            });
            K.text(a7.chooseText);
            K.bind("click.spectrum", function(bd) {
                bd.stopPropagation();
                bd.preventDefault();
                if (aA()) {
                    ao(true);
                    aG()
                }
            });
            c(ac, function(bf, be, bd) {
                aY = (bf / ay);
                F = false;
                if (bd.shiftKey) {
                    aY = Math.round(aY * 10) / 10
                }
                aK()
            }, D, a9);
            c(P, function(be, bd) {
                ab = parseFloat(bd / az);
                F = false;
                if (!a7.showAlpha) {
                    aY = 1
                }
                aK()
            }, D, a9);
            c(L, function(bk, bi, bh) {
                if (!bh.shiftKey) {
                    J = null
                } else {
                    if (!J) {
                        var bf = S * aM;
                        var bd = ah - (aC * ah);
                        var be = Math.abs(bk - bf) > Math.abs(bi - bd);
                        J = be ? "x" : "y"
                    }
                }
                var bg = !J || J === "x";
                var bj = !J || J === "y";
                if (bg) {
                    S = parseFloat(bk / aM)
                }
                if (bj) {
                    aC = parseFloat((ah - bi) / ah)
                }
                F = false;
                if (!a7.showAlpha) {
                    aY = 1
                }
                aK()
            }, D, a9);
            if ( !! W) {
                ae(W);
                aD();
                at = Y || tinycolor(W).format;
                aU(W)
            } else {
                aD()
            }
            if (a3) {
                C()
            }
            function bb(bd) {
                if (bd.data && bd.data.ignore) {
                    ae(e(this).data("color"));
                    aK()
                } else {
                    ae(e(this).data("color"));
                    aK();
                    ao(true);
                    aG()
                }
                return false
            }
            var ba = k ? "mousedown.spectrum" : "click.spectrum touchstart.spectrum";
            T.delegate(".sp-thumb-el", ba, bb);
            a6.delegate(".sp-thumb-el:nth-child(1)", ba, {
                ignore: true
            }, bb);
            e("li[data-toggle]", aw).unbind("click").bind("click", function() {
                var bd = this;
                var bf = e(bd).width();
                var be = e(bd).offset().left - e(bd).parents(".slide-tab").offset().left;
                e(bd).siblings(".active").removeClass("active");
                console.log("width:" + bf + " height:" + be);
                e(bd).parent().siblings(".slider").animate({
                    left: be,
                    width: bf
                }, 200, "easeOutCubic", function() {
                    e(bd).addClass("active")
                });
                var bg = e(bd).attr("data-role");
                if (bg == "base") {
                    e(a0).fadeOut(200, function() {
                        e(A).fadeIn(200)
                    })
                } else {
                    e(A).fadeOut(200, function() {
                        e(a0).fadeIn(200);
                        var bj = e(a8).siblings("input[name*=alpha]").val();
                        var bh = e(a8).siblings("input[name*=color]").val();
                        var bi = Util.hexToRgba(bh, bj);
                        console.info(bi);
                        af()
                    })
                }
            })
        }
        function aQ() {
            if (y && j.localStorage) {
                try {
                    var ba = j.localStorage[y].split(",#");
                    if (ba.length > 1) {
                        delete j.localStorage[y];
                        e.each(ba, function(bc, bd) {
                            aU(bd)
                        })
                    }
                } catch (bb) {}
                try {
                    aI = j.localStorage[y].split(";")
                } catch (bb) {}
            }
        }
        function aU(ba) {
            if (Z) {
                var bb = tinycolor(ba).toRgbString();
                if (!a5[bb] && e.inArray(bb, aI) === -1) {
                    aI.push(bb);
                    while (aI.length > aH) {
                        aI.shift()
                    }
                }
                if (y && j.localStorage) {
                    try {
                        j.localStorage[y] = aI.join(";")
                    } catch (bc) {}
                }
            }
        }
        function aW() {
            var bb = [];
            if (a7.showPalette) {
                for (i = 0; i < aI.length; i++) {
                    var ba = tinycolor(aI[i]).toRgbString();
                    if (!a5[ba]) {
                        bb.push(aI[i])
                    }
                }
            }
            return bb.reverse().slice(0, a7.maxSelectionSize)
        }
        function aZ() {
            var ba = aS();
            var bb = e.map(am, function(bc, bd) {
                return w(bc, ba, "sp-palette-row sp-palette-row-" + bd, a7.preferredFormat)
            });
            aQ();
            if (aI) {
                bb.push(w(aW(), ba, "sp-palette-row sp-palette-row-selection", a7.preferredFormat))
            }
            T.html(bb.join(""))
        }
        function ar() {
            if (a7.showInitial) {
                var ba = aP;
                var bb = aS();
                a6.html(w([ba, bb], bb, "sp-palette-row-initial", a7.preferredFormat))
            }
        }
        function D() {
            if (ah <= 0 || aM <= 0 || az <= 0) {
                af()
            }
            aO.addClass(z);
            J = null;
            G.trigger("dragstart.spectrum", [aS()])
        }
        function a9() {
            aO.removeClass(z);
            G.trigger("dragstop.spectrum", [aS()])
        }
        function aR() {
            var bb = N.val();
            if ((bb === null || bb === "") && a4) {
                ae(null);
                ao(true)
            } else {
                var ba = tinycolor(bb);
                if (ba.ok) {
                    ae(ba);
                    ao(true)
                } else {
                    N.addClass("sp-validation-error")
                }
            }
        }
        function ax() {
            if (R) {
                aG()
            } else {
                C()
            }
        }
        function C() {
            var ba = e.Event("beforeShow.spectrum");
            if (R) {
                af();
                return
            }
            G.trigger(ba, [aS()]);
            if (U.beforeShow(aS(), a8) === false || ba.isDefaultPrevented()) {
                return
            }
            r();
            R = true;
            e(aa).bind("click.spectrum", aG);
            e(j).bind("resize.spectrum", H);
            aT.addClass("sp-active");
            aO.removeClass("sp-hidden");
            af();
            aD();
            aP = aS();
            ar();
            U.show(aP);
            G.trigger("show.spectrum", [aP])
        }
        function aG(bb) {
            if (bb && bb.type == "click" && bb.button == 2) {
                return
            }
            if (!R || a3) {
                return
            }
            R = false;
            e(aa).unbind("click.spectrum", aG);
            e(j).unbind("resize.spectrum", H);
            aT.removeClass("sp-active");
            aO.addClass("sp-hidden");
            var ba = !tinycolor.equals(aS(), aP);
            if (ba) {
                if (I && bb !== "cancel") {
                    ao(true)
                } else {
                    au()
                }
            }
            U.hide(aS());
            G.trigger("hide.spectrum", [aS()])
        }
        function au() {
            ae(aP, true)
        }
        function ae(ba, bc) {
            if (tinycolor.equals(ba, aS())) {
                aD();
                return
            }
            var bb, bd;
            if (!ba && a4) {
                F = true
            } else {
                F = false;
                bb = tinycolor(ba);
                bd = bb.toHsv();
                ab = (bd.h % 360) / 360;
                S = bd.s;
                aC = bd.v;
                aY = bd.a
            }
            aD();
            if (bb && bb.ok && !bc) {
                at = Y || bb.format
            }
        }
        function aS(ba) {
            ba = ba || {};
            if (a4 && F) {
                return null
            }
            return tinycolor.fromRatio({
                h: ab,
                s: S,
                v: aC,
                a: Math.round(aY * 100) / 100
            }, {
                format: ba.format || at
            })
        }
        function aA() {
            return !N.hasClass("sp-validation-error")
        }
        function aK() {
            aD();
            U.move(aS(), a8);
            G.trigger("move.spectrum", [aS()])
        }
        function aD() {
            N.removeClass("sp-validation-error");
            a1();
            var bc = tinycolor.fromRatio({
                h: ab,
                s: 1,
                v: 1
            });
            L.css("background-color", bc.toHexString());
            var bh = at;
            if (aY < 1 && !(aY === 0 && bh === "name")) {
                if (bh === "hex" || bh === "hex3" || bh === "hex6" || bh === "name") {
                    bh = "rgb"
                }
            }
            var ba = aS({
                    format: bh
                }),
                bd = "";
            M.removeClass("sp-clear-display");
            M.css("background-color", "transparent");
            if (!ba && a4) {
                M.addClass("sp-clear-display")
            } else {
                var be = ba.toHexString(),
                    bi = ba.toRgbString();
                if (n || ba.alpha === 1) {
                    M.css("background-color", bi)
                } else {
                    M.css("background-color", "transparent");
                    M.css("filter", ba.toFilter())
                }
                if (a7.showAlpha) {
                    var bf = ba.toRgb();
                    bf.a = 0;
                    var bb = tinycolor(bf).toRgbString();
                    var bg = "linear-gradient(left, " + bb + ", " + be + ")";
                    if (k) {
                        aE.css("filter", tinycolor(bb).toFilter({
                            gradientType: 1
                        }, be))
                    } else {
                        aE.css("background", "-webkit-" + bg);
                        aE.css("background", "-moz-" + bg);
                        aE.css("background", "-ms-" + bg);
                        aE.css("background", "linear-gradient(to right, " + bb + ", " + be + ")")
                    }
                }
                bd = ba.toString(bh)
            }
            if (a7.showInput) {
                N.val(bd)
            }
            if (a7.showPalette) {
                aZ()
            }
            ar()
        }
        function a1() {
            var bc = S;
            var ba = aC;
            if (a4 && F) {
                aF.hide();
                a2.hide();
                aL.hide()
            } else {
                aF.show();
                a2.show();
                aL.show();
                var bf = bc * aM;
                var bd = ah - (ba * ah);
                bf = Math.max(-aN, Math.min(aM - aN, bf - aN));
                bd = Math.max(-aN, Math.min(ah - aN, bd - aN));
                aL.css({
                    top: bd + "px",
                    left: bf + "px"
                });
                var bb = aY * ay;
                aF.css({
                    left: (bb - (aX / 2)) + "px"
                });
                var be = (ab) * az;
                a2.css({
                    top: (be - aq) + "px"
                })
            }
        }
        function ao(bb) {
            var ba = aS(),
                bd = "",
                bc = !tinycolor.equals(ba, aP);
            if (ba) {
                bd = ba.toString(at);
                aU(ba)
            }
            if (V) {
                G.val(bd)
            }
            aP = ba;
            if (bb && bc) {
                U.change(ba);
                G.trigger("change", [ba])
            }
        }
        function af() {
            aM = L.width();
            ah = L.height();
            aN = aL.height();
            O = P.width();
            az = P.height();
            aq = a2.height();
            ay = ac.width();
            aX = aF.width();
            if (!a3) {
                aO.css("position", "absolute");
                aO.offset(a(aO, av))
            }
            a1();
            if (a7.showPalette) {
                aZ()
            }
            G.trigger("reflow.spectrum")
        }
        function B() {
            G.show();
            av.unbind("click.spectrum touchstart.spectrum");
            aO.remove();
            aT.remove();
            d[ag.id] = null
        }
        function ad(ba, bb) {
            if (ba === g) {
                return e.extend({}, a7)
            }
            if (bb === g) {
                return a7[ba]
            }
            a7[ba] = bb;
            x()
        }
        function ai() {
            aV = false;
            G.attr("disabled", false);
            av.removeClass("sp-disabled")
        }
        function X() {
            aG();
            aV = true;
            G.attr("disabled", true);
            av.addClass("sp-disabled")
        }
        aJ();
        var ag = {
            show: C,
            hide: aG,
            toggle: ax,
            reflow: af,
            option: ad,
            enable: ai,
            disable: X,
            set: function(ba) {
                ae(ba);
                ao()
            },
            get: aS,
            destroy: B,
            container: aO
        };
        ag.id = d.push(ag) - 1;
        return ag
    }
    function a(E, F) {
        var D = 0;
        var B = E.outerWidth();
        var H = E.outerHeight();
        var x = F.outerHeight();
        var G = E[0].ownerDocument;
        var y = G.documentElement;
        var C = y.clientWidth + e(G).scrollLeft();
        var z = y.clientHeight + e(G).scrollTop();
        var A = F.offset();
        A.top += x;
        A.left -= Math.min(A.left, (A.left + B > C && C > B) ? Math.abs(A.left + B - C) : 0) + 4;
        A.top -= Math.min(A.top, ((A.top + H > z && z > H) ? Math.abs(H + x - D) : D)) - 5;
        return A
    }
    function b() {}
    function m(x) {
        x.stopPropagation()
    }
    function v(y, z) {
        var A = Array.prototype.slice;
        var x = A.call(arguments, 2);
        return function() {
            return y.apply(z, x.concat(A.call(arguments)))
        }
    }
    function c(C, H, y, z) {
        H = H ||
        function() {};
        y = y ||
        function() {};
        z = z ||
        function() {};
        var I = C.ownerDocument || document;
        var K = false;
        var B = {};
        var L = 0;
        var J = 0;
        var E = ("ontouchstart" in j);
        var D = {};
        D.selectstart = G;
        D.dragstart = G;
        D["touchmove mousemove"] = A;
        D["touchend mouseup"] = F;

        function G(M) {
            if (M.stopPropagation) {
                M.stopPropagation()
            }
            if (M.preventDefault) {
                M.preventDefault()
            }
            M.returnValue = false
        }
        function A(Q) {
            if (K) {
                if (k && document.documentMode < 9 && !Q.button) {
                    return F()
                }
                var P = Q.originalEvent.touches;
                var N = P ? P[0].pageX : Q.pageX;
                var M = P ? P[0].pageY : Q.pageY;
                var R = Math.max(0, Math.min(N - B.left, J));
                var O = Math.max(0, Math.min(M - B.top, L));
                if (E) {
                    G(Q)
                }
                H.apply(C, [R, O, Q])
            }
        }
        function x(O) {
            var M = (O.which) ? (O.which == 3) : (O.button == 2);
            var N = O.originalEvent.touches;
            if (!M && !K) {
                if (y.apply(C, arguments) !== false) {
                    K = true;
                    L = e(C).height();
                    J = e(C).width();
                    B = e(C).offset();
                    e(I).bind(D);
                    e(I.body).addClass("sp-dragging");
                    if (!E) {
                        A(O)
                    }
                    G(O)
                }
            }
        }
        function F() {
            if (K) {
                e(I).unbind(D);
                e(I.body).removeClass("sp-dragging");
                z.apply(C, arguments)
            }
            K = false
        }
        e(C).bind("touchstart mousedown", x)
    }
    function f(y, A, x) {
        var z;
        return function() {
            var C = this,
                B = arguments;
            var D = function() {
                z = null;
                y.apply(C, B)
            };
            if (x) {
                clearTimeout(z)
            }
            if (x || !z) {
                z = setTimeout(D, A)
            }
        }
    }
    function h() {
        if (j.console) {
            if (Function.prototype.bind) {
                h = Function.prototype.bind.call(console.log, console)
            } else {
                h = function() {
                    Function.prototype.apply.call(console.log, console, arguments)
                }
            }
            h.apply(this, arguments)
        }
    }
    var l = "spectrum.id";
    e.fn.spectrum = function(A, x) {
        if (typeof A == "string") {
            var z = this;
            var y = Array.prototype.slice.call(arguments, 1);
            this.each(function() {
                var B = d[e(this).data(l)];
                if (B) {
                    var C = B[A];
                    if (!C) {
                        throw new Error("Spectrum: no such method: '" + A + "'")
                    }
                    if (A == "get") {
                        z = B.get()
                    } else {
                        if (A == "container") {
                            z = B.container
                        } else {
                            if (A == "option") {
                                z = B.option.apply(B, y)
                            } else {
                                if (A == "destroy") {
                                    B.destroy();
                                    e(this).removeData(l)
                                } else {
                                    C.apply(B, y)
                                }
                            }
                        }
                    }
                }
            });
            return z
        }
        return this.spectrum("destroy").each(function() {
            var B = e.extend({}, A, e(this).data());
            var C = u(this, B);
            e(this).data(l, C.id)
        })
    };
    e.fn.spectrum.load = true;
    e.fn.spectrum.loadOpts = {};
    e.fn.spectrum.draggable = c;
    e.fn.spectrum.defaults = p;
    e.spectrum = {};
    e.spectrum.localization = {};
    e.spectrum.palettes = {};
    e.fn.spectrum.processNativeColorInputs = function() {
        if (!o) {
            e("input[type=color]").spectrum({
                preferredFormat: "hex6"
            })
        }
    };
    (function() {
        var Q = /^[\s,#]+/,
            K = /\s+$/,
            L = 0,
            x = Math,
            X = x.round,
            E = x.min,
            H = x.max,
            G = x.random;

        function V(ag, ad) {
            ag = (ag) ? ag : "";
            ad = ad || {};
            if (typeof ag == "object" && ag.hasOwnProperty("_tc_id")) {
                return ag
            }
            var ai = M(ag);
            var ae = ai.r,
                ah = ai.g,
                aj = ai.b,
                ak = ai.a,
                af = X(100 * ak) / 100,
                al = ad.format || ai.format;
            if (ae < 1) {
                ae = X(ae)
            }
            if (ah < 1) {
                ah = X(ah)
            }
            if (aj < 1) {
                aj = X(aj)
            }
            return {
                ok: ai.ok,
                format: al,
                _tc_id: L++,
                alpha: ak,
                getAlpha: function() {
                    return ak
                },
                setAlpha: function(am) {
                    ak = N(am);
                    af = X(100 * ak) / 100
                },
                toHsv: function() {
                    var am = P(ae, ah, aj);
                    return {
                        h: am.h * 360,
                        s: am.s,
                        v: am.v,
                        a: ak
                    }
                },
                toHsvString: function() {
                    var an = P(ae, ah, aj);
                    var ap = X(an.h * 360),
                        ao = X(an.s * 100),
                        am = X(an.v * 100);
                    return (ak == 1) ? "hsv(" + ap + ", " + ao + "%, " + am + "%)" : "hsva(" + ap + ", " + ao + "%, " + am + "%, " + af + ")"
                },
                toHsl: function() {
                    var am = Y(ae, ah, aj);
                    return {
                        h: am.h * 360,
                        s: am.s,
                        l: am.l,
                        a: ak
                    }
                },
                toHslString: function() {
                    var an = Y(ae, ah, aj);
                    var ap = X(an.h * 360),
                        ao = X(an.s * 100),
                        am = X(an.l * 100);
                    return (ak == 1) ? "hsl(" + ap + ", " + ao + "%, " + am + "%)" : "hsla(" + ap + ", " + ao + "%, " + am + "%, " + af + ")"
                },
                toHex: function(am) {
                    return W(ae, ah, aj, am)
                },
                toHexString: function(am) {
                    return "#" + this.toHex(am)
                },
                toHex8: function() {
                    return B(ae, ah, aj, ak)
                },
                toHex8String: function() {
                    return "#" + this.toHex8()
                },
                toRgb: function() {
                    return {
                        r: X(ae),
                        g: X(ah),
                        b: X(aj),
                        a: ak
                    }
                },
                toRgbString: function() {
                    return (ak == 1) ? "rgb(" + X(ae) + ", " + X(ah) + ", " + X(aj) + ")" : "rgba(" + X(ae) + ", " + X(ah) + ", " + X(aj) + ", " + af + ")"
                },
                toPercentageRgb: function() {
                    return {
                        r: X(aa(ae, 255) * 100) + "%",
                        g: X(aa(ah, 255) * 100) + "%",
                        b: X(aa(aj, 255) * 100) + "%",
                        a: ak
                    }
                },
                toPercentageRgbString: function() {
                    return (ak == 1) ? "rgb(" + X(aa(ae, 255) * 100) + "%, " + X(aa(ah, 255) * 100) + "%, " + X(aa(aj, 255) * 100) + "%)" : "rgba(" + X(aa(ae, 255) * 100) + "%, " + X(aa(ah, 255) * 100) + "%, " + X(aa(aj, 255) * 100) + "%, " + af + ")"
                },
                toName: function() {
                    if (ak === 0) {
                        return "transparent"
                    }
                    return ac[W(ae, ah, aj, true)] || false
                },
                toFilter: function(ap) {
                    var aq = "#" + B(ae, ah, aj, ak);
                    var an = aq;
                    var am = ad && ad.gradientType ? "GradientType = 1, " : "";
                    if (ap) {
                        var ao = V(ap);
                        an = ao.toHex8String()
                    }
                    return "progid:DXImageTransform.Microsoft.gradient(" + am + "startColorstr=" + aq + ",endColorstr=" + an + ")"
                },
                toString: function(aq) {
                    var an = !! aq;
                    aq = aq || this.format;
                    var ap = false;
                    var am = !an && ak < 1 && ak > 0;
                    var ao = am && (aq === "hex" || aq === "hex6" || aq === "hex3" || aq === "name");
                    if (aq === "rgb") {
                        ap = this.toRgbString()
                    }
                    if (aq === "prgb") {
                        ap = this.toPercentageRgbString()
                    }
                    if (aq === "hex" || aq === "hex6") {
                        ap = this.toHexString()
                    }
                    if (aq === "hex3") {
                        ap = this.toHexString(true)
                    }
                    if (aq === "hex8") {
                        ap = this.toHex8String()
                    }
                    if (aq === "name") {
                        ap = this.toName()
                    }
                    if (aq === "hsl") {
                        ap = this.toHslString()
                    }
                    if (aq === "hsv") {
                        ap = this.toHsvString()
                    }
                    if (ao) {
                        return this.toRgbString()
                    }
                    return ap || this.toHexString()
                }
            }
        }
        V.fromRatio = function(ad, ag) {
            if (typeof ad == "object") {
                var ae = {};
                for (var af in ad) {
                    if (ad.hasOwnProperty(af)) {
                        if (af === "a") {
                            ae[af] = ad[af]
                        } else {
                            ae[af] = D(ad[af])
                        }
                    }
                }
                ad = ae
            }
            return V(ad, ag)
        };

        function M(ae) {
            var af = {
                r: 0,
                g: 0,
                b: 0
            };
            var ad = 1;
            var ag = false;
            var ah = false;
            if (typeof ae == "string") {
                ae = F(ae)
            }
            if (typeof ae == "object") {
                if (ae.hasOwnProperty("r") && ae.hasOwnProperty("g") && ae.hasOwnProperty("b")) {
                    af = I(ae.r, ae.g, ae.b);
                    ag = true;
                    ah = String(ae.r).substr(-1) === "%" ? "prgb" : "rgb"
                } else {
                    if (ae.hasOwnProperty("h") && ae.hasOwnProperty("s") && ae.hasOwnProperty("v")) {
                        ae.s = D(ae.s);
                        ae.v = D(ae.v);
                        af = T(ae.h, ae.s, ae.v);
                        ag = true;
                        ah = "hsv"
                    } else {
                        if (ae.hasOwnProperty("h") && ae.hasOwnProperty("s") && ae.hasOwnProperty("l")) {
                            ae.s = D(ae.s);
                            ae.l = D(ae.l);
                            af = J(ae.h, ae.s, ae.l);
                            ag = true;
                            ah = "hsl"
                        }
                    }
                }
                if (ae.hasOwnProperty("a")) {
                    ad = ae.a
                }
            }
            ad = N(ad);
            return {
                ok: ag,
                format: ae.format || ah,
                r: E(255, H(af.r, 0)),
                g: E(255, H(af.g, 0)),
                b: E(255, H(af.b, 0)),
                a: ad
            }
        }
        function I(af, ae, ad) {
            return {
                r: aa(af, 255) * 255,
                g: aa(ae, 255) * 255,
                b: aa(ad, 255) * 255
            }
        }
        function Y(ad, ah, aj) {
            ad = aa(ad, 255);
            ah = aa(ah, 255);
            aj = aa(aj, 255);
            var ak = H(ad, ah, aj),
                af = E(ad, ah, aj);
            var ag, al, ae = (ak + af) / 2;
            if (ak == af) {
                ag = al = 0
            } else {
                var ai = ak - af;
                al = ae > 0.5 ? ai / (2 - ak - af) : ai / (ak + af);
                switch (ak) {
                    case ad:
                        ag = (ah - aj) / ai + (ah < aj ? 6 : 0);
                        break;
                    case ah:
                        ag = (aj - ad) / ai + 2;
                        break;
                    case aj:
                        ag = (ad - ah) / ai + 4;
                        break
                }
                ag /= 6
            }
            return {
                h: ag,
                s: al,
                l: ae
            }
        }
        function J(ai, al, ah) {
            var ad, aj, ak;
            ai = aa(ai, 360);
            al = aa(al, 100);
            ah = aa(ah, 100);

            function ag(ao, an, am) {
                if (am < 0) {
                    am += 1
                }
                if (am > 1) {
                    am -= 1
                }
                if (am < 1 / 6) {
                    return ao + (an - ao) * 6 * am
                }
                if (am < 1 / 2) {
                    return an
                }
                if (am < 2 / 3) {
                    return ao + (an - ao) * (2 / 3 - am) * 6
                }
                return ao
            }
            if (al === 0) {
                ad = aj = ak = ah
            } else {
                var ae = ah < 0.5 ? ah * (1 + al) : ah + al - ah * al;
                var af = 2 * ah - ae;
                ad = ag(af, ae, ai + 1 / 3);
                aj = ag(af, ae, ai);
                ak = ag(af, ae, ai - 1 / 3)
            }
            return {
                r: ad * 255,
                g: aj * 255,
                b: ak * 255
            }
        }
        function P(ad, ag, ai) {
            ad = aa(ad, 255);
            ag = aa(ag, 255);
            ai = aa(ai, 255);
            var aj = H(ad, ag, ai),
                ae = E(ad, ag, ai);
            var af, al, ak = aj;
            var ah = aj - ae;
            al = aj === 0 ? 0 : ah / aj;
            if (aj == ae) {
                af = 0
            } else {
                switch (aj) {
                    case ad:
                        af = (ag - ai) / ah + (ag < ai ? 6 : 0);
                        break;
                    case ag:
                        af = (ai - ad) / ah + 2;
                        break;
                    case ai:
                        af = (ad - ag) / ah + 4;
                        break
                }
                af /= 6
            }
            return {
                h: af,
                s: al,
                v: ak
            }
        }
        function T(ah, ao, am) {
            ah = aa(ah, 360) * 6;
            ao = aa(ao, 100);
            am = aa(am, 100);
            var ag = x.floor(ah),
                aj = ah - ag,
                af = am * (1 - ao),
                ae = am * (1 - aj * ao),
                an = am * (1 - (1 - aj) * ao),
                al = ag % 6,
                ad = [am, ae, af, af, an, am][al],
                ai = [an, am, am, ae, af, af][al],
                ak = [af, af, an, am, am, ae][al];
            return {
                r: ad * 255,
                g: ai * 255,
                b: ak * 255
            }
        }
        function W(ag, af, ad, ah) {
            var ae = [C(X(ag).toString(16)), C(X(af).toString(16)), C(X(ad).toString(16))];
            if (ah && ae[0].charAt(0) == ae[0].charAt(1) && ae[1].charAt(0) == ae[1].charAt(1) && ae[2].charAt(0) == ae[2].charAt(1)) {
                return ae[0].charAt(0) + ae[1].charAt(0) + ae[2].charAt(0)
            }
            return ae.join("")
        }
        function B(ah, ag, ad, ae) {
            var af = [C(Z(ae)), C(X(ah).toString(16)), C(X(ag).toString(16)), C(X(ad).toString(16))];
            return af.join("")
        }
        V.equals = function(ae, ad) {
            if (!ae || !ad) {
                return false
            }
            return V(ae).toRgbString() == V(ad).toRgbString()
        };
        V.random = function() {
            return V.fromRatio({
                r: G(),
                g: G(),
                b: G()
            })
        };
        V.desaturate = function(ae, af) {
            af = (af === 0) ? 0 : (af || 10);
            var ad = V(ae).toHsl();
            ad.s -= af / 100;
            ad.s = S(ad.s);
            return V(ad)
        };
        V.saturate = function(ae, af) {
            af = (af === 0) ? 0 : (af || 10);
            var ad = V(ae).toHsl();
            ad.s += af / 100;
            ad.s = S(ad.s);
            return V(ad)
        };
        V.greyscale = function(ad) {
            return V.desaturate(ad, 100)
        };
        V.lighten = function(ae, af) {
            af = (af === 0) ? 0 : (af || 10);
            var ad = V(ae).toHsl();
            ad.l += af / 100;
            ad.l = S(ad.l);
            return V(ad)
        };
        V.darken = function(ae, af) {
            af = (af === 0) ? 0 : (af || 10);
            var ad = V(ae).toHsl();
            ad.l -= af / 100;
            ad.l = S(ad.l);
            return V(ad)
        };
        V.complement = function(ae) {
            var ad = V(ae).toHsl();
            ad.h = (ad.h + 180) % 360;
            return V(ad)
        };
        V.triad = function(ae) {
            var ad = V(ae).toHsl();
            var af = ad.h;
            return [V(ae), V({
                h: (af + 120) % 360,
                s: ad.s,
                l: ad.l
            }), V({
                h: (af + 240) % 360,
                s: ad.s,
                l: ad.l
            })]
        };
        V.tetrad = function(ae) {
            var ad = V(ae).toHsl();
            var af = ad.h;
            return [V(ae), V({
                h: (af + 90) % 360,
                s: ad.s,
                l: ad.l
            }), V({
                h: (af + 180) % 360,
                s: ad.s,
                l: ad.l
            }), V({
                h: (af + 270) % 360,
                s: ad.s,
                l: ad.l
            })]
        };
        V.splitcomplement = function(ae) {
            var ad = V(ae).toHsl();
            var af = ad.h;
            return [V(ae), V({
                h: (af + 72) % 360,
                s: ad.s,
                l: ad.l
            }), V({
                h: (af + 216) % 360,
                s: ad.s,
                l: ad.l
            })]
        };
        V.analogous = function(ae, ah, ai) {
            ah = ah || 6;
            ai = ai || 30;
            var ad = V(ae).toHsl();
            var ag = 360 / ai;
            var af = [V(ae)];
            for (ad.h = ((ad.h - (ag * ah >> 1)) + 720) % 360; --ah;) {
                ad.h = (ad.h + ag) % 360;
                af.push(V(ad))
            }
            return af
        };
        V.monochromatic = function(af, ai) {
            ai = ai || 6;
            var ah = V(af).toHsv();
            var ak = ah.h,
                aj = ah.s,
                ae = ah.v;
            var ag = [];
            var ad = 1 / ai;
            while (ai--) {
                ag.push(V({
                    h: ak,
                    s: aj,
                    v: ae
                }));
                ae = (ae + ad) % 1
            }
            return ag
        };
        V.readability = function(ah, af) {
            var ag = V(ah).toRgb();
            var ae = V(af).toRgb();
            var ad = (ag.r * 299 + ag.g * 587 + ag.b * 114) / 1000;
            var aj = (ae.r * 299 + ae.g * 587 + ae.b * 114) / 1000;
            var ai = (Math.max(ag.r, ae.r) - Math.min(ag.r, ae.r) + Math.max(ag.g, ae.g) - Math.min(ag.g, ae.g) + Math.max(ag.b, ae.b) - Math.min(ag.b, ae.b));
            return {
                brightness: Math.abs(ad - aj),
                color: ai
            }
        };
        V.readable = function(ae, ad) {
            var af = V.readability(ae, ad);
            return af.brightness > 125 && af.color > 500
        };
        V.mostReadable = function(ak, aj) {
            var ag = null;
            var ae = 0;
            var al = false;
            for (var ai = 0; ai < aj.length; ai++) {
                var af = V.readability(ak, aj[ai]);
                var ah = af.brightness > 125 && af.color > 500;
                var ad = 3 * (af.brightness / 125) + (af.color / 500);
                if ((ah && !al) || (ah && al && ad > ae) || ((!ah) && (!al) && ad > ae)) {
                    al = ah;
                    ae = ad;
                    ag = V(aj[ai])
                }
            }
            return ag
        };
        var O = V.names = {
            aliceblue: "f0f8ff",
            antiquewhite: "faebd7",
            aqua: "0ff",
            aquamarine: "7fffd4",
            azure: "f0ffff",
            beige: "f5f5dc",
            bisque: "ffe4c4",
            black: "000",
            blanchedalmond: "ffebcd",
            blue: "00f",
            blueviolet: "8a2be2",
            brown: "a52a2a",
            burlywood: "deb887",
            burntsienna: "ea7e5d",
            cadetblue: "5f9ea0",
            chartreuse: "7fff00",
            chocolate: "d2691e",
            coral: "ff7f50",
            cornflowerblue: "6495ed",
            cornsilk: "fff8dc",
            crimson: "dc143c",
            cyan: "0ff",
            darkblue: "00008b",
            darkcyan: "008b8b",
            darkgoldenrod: "b8860b",
            darkgray: "a9a9a9",
            darkgreen: "006400",
            darkgrey: "a9a9a9",
            darkkhaki: "bdb76b",
            darkmagenta: "8b008b",
            darkolivegreen: "556b2f",
            darkorange: "ff8c00",
            darkorchid: "9932cc",
            darkred: "8b0000",
            darksalmon: "e9967a",
            darkseagreen: "8fbc8f",
            darkslateblue: "483d8b",
            darkslategray: "2f4f4f",
            darkslategrey: "2f4f4f",
            darkturquoise: "00ced1",
            darkviolet: "9400d3",
            deeppink: "ff1493",
            deepskyblue: "00bfff",
            dimgray: "696969",
            dimgrey: "696969",
            dodgerblue: "1e90ff",
            firebrick: "b22222",
            floralwhite: "fffaf0",
            forestgreen: "228b22",
            fuchsia: "f0f",
            gainsboro: "dcdcdc",
            ghostwhite: "f8f8ff",
            gold: "ffd700",
            goldenrod: "daa520",
            gray: "808080",
            green: "008000",
            greenyellow: "adff2f",
            grey: "808080",
            honeydew: "f0fff0",
            hotpink: "ff69b4",
            indianred: "cd5c5c",
            indigo: "4b0082",
            ivory: "fffff0",
            khaki: "f0e68c",
            lavender: "e6e6fa",
            lavenderblush: "fff0f5",
            lawngreen: "7cfc00",
            lemonchiffon: "fffacd",
            lightblue: "add8e6",
            lightcoral: "f08080",
            lightcyan: "e0ffff",
            lightgoldenrodyellow: "fafad2",
            lightgray: "d3d3d3",
            lightgreen: "90ee90",
            lightgrey: "d3d3d3",
            lightpink: "ffb6c1",
            lightsalmon: "ffa07a",
            lightseagreen: "20b2aa",
            lightskyblue: "87cefa",
            lightslategray: "789",
            lightslategrey: "789",
            lightsteelblue: "b0c4de",
            lightyellow: "ffffe0",
            lime: "0f0",
            limegreen: "32cd32",
            linen: "faf0e6",
            magenta: "f0f",
            maroon: "800000",
            mediumaquamarine: "66cdaa",
            mediumblue: "0000cd",
            mediumorchid: "ba55d3",
            mediumpurple: "9370db",
            mediumseagreen: "3cb371",
            mediumslateblue: "7b68ee",
            mediumspringgreen: "00fa9a",
            mediumturquoise: "48d1cc",
            mediumvioletred: "c71585",
            midnightblue: "191970",
            mintcream: "f5fffa",
            mistyrose: "ffe4e1",
            moccasin: "ffe4b5",
            navajowhite: "ffdead",
            navy: "000080",
            oldlace: "fdf5e6",
            olive: "808000",
            olivedrab: "6b8e23",
            orange: "ffa500",
            orangered: "ff4500",
            orchid: "da70d6",
            palegoldenrod: "eee8aa",
            palegreen: "98fb98",
            paleturquoise: "afeeee",
            palevioletred: "db7093",
            papayawhip: "ffefd5",
            peachpuff: "ffdab9",
            peru: "cd853f",
            pink: "ffc0cb",
            plum: "dda0dd",
            powderblue: "b0e0e6",
            purple: "800080",
            red: "f00",
            rosybrown: "bc8f8f",
            royalblue: "4169e1",
            saddlebrown: "8b4513",
            salmon: "fa8072",
            sandybrown: "f4a460",
            seagreen: "2e8b57",
            seashell: "fff5ee",
            sienna: "a0522d",
            silver: "c0c0c0",
            skyblue: "87ceeb",
            slateblue: "6a5acd",
            slategray: "708090",
            slategrey: "708090",
            snow: "fffafa",
            springgreen: "00ff7f",
            steelblue: "4682b4",
            tan: "d2b48c",
            teal: "008080",
            thistle: "d8bfd8",
            tomato: "ff6347",
            turquoise: "40e0d0",
            violet: "ee82ee",
            wheat: "f5deb3",
            white: "fff",
            whitesmoke: "f5f5f5",
            yellow: "ff0",
            yellowgreen: "9acd32"
        };
        var ac = V.hexNames = A(O);

        function A(af) {
            var ae = {};
            for (var ad in af) {
                if (af.hasOwnProperty(ad)) {
                    ae[af[ad]] = ad
                }
            }
            return ae
        }
        function N(ad) {
            ad = parseFloat(ad);
            if (isNaN(ad) || ad < 0 || ad > 1) {
                ad = 1
            }
            return ad
        }
        function aa(af, ad) {
            if (R(af)) {
                af = "100%"
            }
            var ae = ab(af);
            af = E(ad, H(0, parseFloat(af)));
            if (ae) {
                af = parseInt(af * ad, 10) / 100
            }
            if ((x.abs(af - ad) < 0.000001)) {
                return 1
            }
            return (af % ad) / parseFloat(ad)
        }
        function S(ad) {
            return E(1, H(0, ad))
        }
        function z(ad) {
            return parseInt(ad, 16)
        }
        function R(ad) {
            return typeof ad == "string" && ad.indexOf(".") != -1 && parseFloat(ad) === 1
        }
        function ab(ad) {
            return typeof ad === "string" && ad.indexOf("%") != -1
        }
        function C(ad) {
            return ad.length == 1 ? "0" + ad : "" + ad
        }
        function D(ad) {
            if (ad <= 1) {
                ad = (ad * 100) + "%"
            }
            return ad
        }
        function Z(ad) {
            return Math.round(parseFloat(ad) * 255).toString(16)
        }
        function U(ad) {
            return (z(ad) / 255)
        }
        var y = (function() {
            var ah = "[-\\+]?\\d+%?";
            var ag = "[-\\+]?\\d*\\.\\d+%?";
            var ad = "(?:" + ag + ")|(?:" + ah + ")";
            var af = "[\\s|\\(]+(" + ad + ")[,|\\s]+(" + ad + ")[,|\\s]+(" + ad + ")\\s*\\)?";
            var ae = "[\\s|\\(]+(" + ad + ")[,|\\s]+(" + ad + ")[,|\\s]+(" + ad + ")[,|\\s]+(" + ad + ")\\s*\\)?";
            return {
                rgb: new RegExp("rgb" + af),
                rgba: new RegExp("rgba" + ae),
                hsl: new RegExp("hsl" + af),
                hsla: new RegExp("hsla" + ae),
                hsv: new RegExp("hsv" + af),
                hex3: /^([0-9a-fA-F]{1})([0-9a-fA-F]{1})([0-9a-fA-F]{1})$/,
                hex6: /^([0-9a-fA-F]{2})([0-9a-fA-F]{2})([0-9a-fA-F]{2})$/,
                hex8: /^([0-9a-fA-F]{2})([0-9a-fA-F]{2})([0-9a-fA-F]{2})([0-9a-fA-F]{2})$/
            }
        })();

        function F(ae) {
            ae = ae.replace(Q, "").replace(K, "").toLowerCase();
            var ad = false;
            if (O[ae]) {
                ae = O[ae];
                ad = true
            } else {
                if (ae == "transparent") {
                    return {
                        r: 0,
                        g: 0,
                        b: 0,
                        a: 0,
                        format: "name"
                    }
                }
            }
            var af;
            if ((af = y.rgb.exec(ae))) {
                return {
                    r: af[1],
                    g: af[2],
                    b: af[3]
                }
            }
            if ((af = y.rgba.exec(ae))) {
                return {
                    r: af[1],
                    g: af[2],
                    b: af[3],
                    a: af[4]
                }
            }
            if ((af = y.hsl.exec(ae))) {
                return {
                    h: af[1],
                    s: af[2],
                    l: af[3]
                }
            }
            if ((af = y.hsla.exec(ae))) {
                return {
                    h: af[1],
                    s: af[2],
                    l: af[3],
                    a: af[4]
                }
            }
            if ((af = y.hsv.exec(ae))) {
                return {
                    h: af[1],
                    s: af[2],
                    v: af[3]
                }
            }
            if ((af = y.hex8.exec(ae))) {
                return {
                    a: U(af[1]),
                    r: z(af[2]),
                    g: z(af[3]),
                    b: z(af[4]),
                    format: ad ? "name" : "hex8"
                }
            }
            if ((af = y.hex6.exec(ae))) {
                return {
                    r: z(af[1]),
                    g: z(af[2]),
                    b: z(af[3]),
                    format: ad ? "name" : "hex"
                }
            }
            if ((af = y.hex3.exec(ae))) {
                return {
                    r: z(af[1] + "" + af[1]),
                    g: z(af[2] + "" + af[2]),
                    b: z(af[3] + "" + af[3]),
                    format: ad ? "name" : "hex"
                }
            }
            return false
        }
        j.tinycolor = V
    })();
    e(function() {
        if (e.fn.spectrum.load) {
            e.fn.spectrum.processNativeColorInputs()
        }
    })
})(window, jQuery);