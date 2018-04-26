var arr = [1, 3, 5, 7, 9, 11, 13, 15];
var x, y, z;
for (var i = 0; i < arr.length; i++) {
    x = arr[i];
    for (var b = 0; b < arr.length; b++) {
        y = arr[b];
        for (var v = 0; v < arr.length; v++) {
            z = arr[v];
            if ((x + y + z )== 20) {
                console.log(x);
                console.log(y);
                console.log(z);
                break;
            }
        }
    }
}