var setting = [0,1,3,5,7,9,2,4,6,8];
localStorage.setItem('watchlist', setting);
var watchlist = localStorage.getItem('watchlist').split(',');
var data = [['a0','b1','c2','d3','e4','f5','g6','h7','i8','j9'], ['a_0','b_1','c_2','d_3','e_4','f_5','g_6','h_7','i_8','j_9']]

var dataLayer1 = [];
data.forEach(function(value, key){
  dataLayer2 = [];
  watchlist.forEach(function(v){
    dataLayer2.push(value[v]);
  });
  dataLayer1[key] = dataLayer2;
});
