const upend = function(e) {
    if (localStorage.getItem('upend') === '') {
        document.body.style.setProperty("-webkit-transform", "rotate(180deg)", null);
        localStorage.setItem('upend', 'upend');
    } else {
        document.body.style.setProperty("-webkit-transform", "rotate(0deg)", null);
        localStorage.setItem('upend', '');
    }
};

document.addEventListener('DOMContentLoaded', function(){
    document.getElementById('upendButton').addEventListener('click', upend);
    if (localStorage.getItem('upend') === 'upend') {
        document.body.style.setProperty("-webkit-transform", "rotate(180deg)", null);
    }
});