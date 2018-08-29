function toggle(eid) {
    var dis = document.getElementById(eid).style.display;
    if (dis === 'none') {
        dis = 'block';
    } else {
        dis = 'none';
    }
    document.getElementById(eid).style.display = dis;
}