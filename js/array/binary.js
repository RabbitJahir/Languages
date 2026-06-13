let a = [1,2,3,4,5,6,7,11]

let find = 5;

let low = 0
let high = a.length-1
while(low<=high){
    let middle = Math.floor((high+low)/2)
    if(a[middle] < find){
        low = middle+1;
    } else if(a[middle] > find){
        high= middle-1
    } else {
        console.log(middle)
        break;
    }
}

if(low>high){
    console.log("not found")
}

