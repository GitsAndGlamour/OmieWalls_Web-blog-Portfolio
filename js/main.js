var $container = $("#inner-container");
var $year2014btn = $("#year-2014");
var $year2015btn = $("#year-2015");
var $year2016btn = $("#year-2016");
var $semesterPrompt = $('<li class="prev"><h3 class="post-subtitle">Choose a semester: </h3></li>');
var $year2014semesters = $('<ul class="pager"><ul>');
var $year2015semesters = $('<ul class="pager"><ul>');
var $year2016semesters = $('<ul class="pager"><ul>');
var $spring2014semester = $('<li class="prev"><a href="#">spring</a></li>');
var $summer2014semester = $('<li class="prev"><a href="#">summer</a></li>');
var $summer2015semester = $('<li class="prev"><a href="#">summer</a></li>');
var $fall2015semester   = $('<li class="prev"><a href="#">fall</a></li>');
var $spring2016semester = $('<li class="prev"><a href="#">spring</a></li>');
var $summer2016semester = $('<li class="prev"><a href="#">summer</a></li>');
$year2014semesters.append('<li class="prev"><h3 class="post-subtitle">Choose a semester: </h3></li>').append($spring2014semester).append($summer2014semester);
$year2015semesters.append('<li class="prev"><h3 class="post-subtitle">Choose a semester: </h3></li>').append($summer2015semester).append($fall2015semester);
$year2016semesters.append('<li class="prev"><h3 class="post-subtitle">Choose a semester: </h3></li>').append($spring2016semester).append($summer2016semester);
var $coursePrompt = $('<li class="prev"><h3 class="post-subtitle">Select a course: </h3></li>');
var $firstSpringCourses  = $('<ul class="pager"><ul>');
var $secondSpringCourses = $('<ul class="pager"><ul>');
var $firstSummerCourses  = $('<ul class="pager"><ul>');
var $secondSummerCourses = $('<ul class="pager"><ul>');
var $fallCourses         = $('<ul class="pager"><ul>');
var $thirdSummerCourses   = $('<ul class="pager"><ul>');
var $infost110btn  = $('<li class="prev"><a href="portfolio/2014/infost-110.html">infost 110</a></li>');
var $infost210btn  = $('<li class="prev"><a href="portfolio/2014/infost-210.html">infost 210</a></li>');
var $infost230btn  = $('<li class="prev"><a href="portfolio/2014/infost-230.html">infost 230</a></li>');
var $infost240btn  = $('<li class="prev"><a href="portfolio/2014/infost-240.html">infost 240</a></li>');
var $compsci201btn = $('<li class="prev"><a href="portfolio/2014/compsci-201.html">compsci 201</a></li>');
var $compsci251btn = $('<li class="prev"><a href="portfolio/2014/compsci-251.html">compsci 251</a></li>');
var $infost340btn  = $('<li class="prev"><a href="portfolio/2015/infost-340.html">infost 340</a></li>');
var $infost375btn  = $('<li class="prev"><a href="portfolio/2015/infost-375.html">infost 375</a></li>');
var $infost310btn  = $('<li class="prev"><a href="portfolio/2015/infost-310.html">infost 310</a></li>');
var $infost410btn  = $('<li class="prev"><a href="portfolio/2015/infost-410.html">infost 410</a></li>');
var $infost430btn  = $('<li class="prev"><a href="portfolio/2015/infost-430.html">infost 430</a></li>');
var $infost491Abtn  = $('<li class="prev"><a href="portfolio/2015/infost-491.html">infost 491</a></li>');
var $art124btn = $('<li class="prev"><a href="portfolio/2016/art-124.html">art 124</a></li>');
var $infost383btn = $('<li class="prev"><a href="portfolio/2016/infost-383.html">infost 383</a></li>');
var $infost440btn = $('<li class="prev"><a href="portfolio/2016/infost-440.html">infost 440</a></li>');
var $infost490btn = $('<li class="prev"><a href="portfolio/2016/infost-490.html">infost 490</a></li>');
var $infost491btn = $('<li class="prev"><a href="portfolio/2016/infost-491.html">infost 491</a></li>');
var $infost584btn = $('<li class="prev"><a href="portfolio/2016/infost-584.html">infost 584</a></li>');
var $infost399btn = $('<li class="prev"><a href="portfolio/2016/infost-399.html">infost 399</a></li>');
$firstSpringCourses.append('<li class="prev"><h3 class="post-subtitle">Select a course: </h3></li>').append($infost110btn).append($infost210btn).append($infost230btn).append($infost230btn).append($infost240btn).append($compsci201btn);
$firstSummerCourses.append('<li class="prev"><h3 class="post-subtitle">Select a course: </h3></li>').append($compsci251btn);
$secondSummerCourses.append('<li class="prev"><h3 class="post-subtitle">Select a course: </h3></li>').append($infost340btn).append($infost375btn);
$fallCourses.append('<li class="prev"><h3 class="post-subtitle">Select a course: </h3></li>').append($infost310btn).append($infost410btn).append($infost430btn).append($infost491Abtn);
$secondSpringCourses.append('<li class="prev"><h3 class="post-subtitle">Select a course: </h3></li>').append($art124btn).append($infost383btn).append($infost440btn).append($infost490btn).append($infost491btn).append($infost584btn);
$thirdSummerCourses.append('<li class="prev"><h3 class="post-subtitle">Select a course: </h3></li>').append($infost399btn);

$year2014btn.click(function(event) {
    event.preventDefault();
    var $semesters = $('<div id="semesters"></div>');
    $container.empty();
    $container.append($year2014semesters);
    $container.append($semesters);
    $spring2014semester.click(function(event) {
        event.preventDefault();
        $semesters.empty();
        $semesters.append($firstSpringCourses);

    });
    $summer2014semester.click(function(event) {
        event.preventDefault();
        $semesters.empty();
        $semesters.append($firstSummerCourses);
    });
});
$year2015btn.click(function(event) {
    event.preventDefault();
    var $semesters = $('<div id="semesters"></div>');
    $container.empty();
    $container.append($year2015semesters);
    $container.append($semesters);

    $summer2015semester.click(function(event) {
        event.preventDefault();
        $semesters.empty();
        $semesters.append($secondSummerCourses);

    });
    $fall2015semester.click(function(event) {
        event.preventDefault();
        $semesters.empty();
        $semesters.append($fallCourses);
    });

});
$year2016btn.click(function(event) {
    event.preventDefault();
    var $semesters = $('<div id="semesters"></div>');
    $container.empty();
    $container.append($year2016semesters);
    $container.append($semesters);

    $spring2016semester.click(function(event) {
        event.preventDefault();
        $semesters.empty();
        $semesters.append($secondSpringCourses);

    });
    $summer2016semester.click(function(event) {
        event.preventDefault();
        $semesters.empty();
        $semesters.append($thirdSummerCourses);
    });
});
