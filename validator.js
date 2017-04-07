function isEmail(email) {
  var re = /^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;
  return re.test(email);
};

function isMobile(mobile) {
  var re = /^(\d+-?)+\d+$/;
  return re.test(mobile);
};
