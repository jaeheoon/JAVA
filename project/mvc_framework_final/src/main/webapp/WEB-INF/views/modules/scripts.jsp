<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- scripts -->
<script src="/assets/js/theme.bundle.min.js"></script>
<!--Smooth scroll locomotive-->
<script src="/assets/vendor/node_modules/js/locomotive-scroll.min.js"></script>
<script src="/assets/vendor/node_modules/js/gsap.min.js"></script>
<script type="text/javascript">
        (function () {
            var scroll = new LocomotiveScroll({
                el: document.querySelector('[data-scroll-container]'),
                smooth: true,
            });
        })();

</script>
<!-- image mouse float -->
<script>
    let vw = window.innerWidth || document.documentElement.clientWidth,
        maxVw = 320;
    vw > maxVw && document.querySelectorAll(".js-hover-img-item").forEach(function (e) {
        let t = e,
            r = (t.getBoundingClientRect(),
                e.querySelector("img")),
            a = r.offsetHeight,
            l = r.offsetWidth;
        e.addEventListener("mouseenter",
            s => {
                e.classList.contains("is-hover") || e.classList.add("is-hover");
                let o = s.clientX - t.offsetLeft - l / 2.7,
                    u = s.offsetY - a / 2.5;
                gsap.set(r, {
                    x: o,
                    y: u,
                    rotate: -4
                })
            }),
            e.addEventListener("mousemove",
                e => {
                    let s = e.clientX - t.offsetLeft - l / 2,
                        o = e.offsetY - r.offsetTop - a * .5;
                    gsap.to(r, {
                        x: s,
                        y: o,
                        rotate: -4
                    })
                }),
            e.addEventListener("mouseleave", () => {
                e.classList.contains("is-hover") && e.classList.remove("is-hover")
            })
    });
</script>