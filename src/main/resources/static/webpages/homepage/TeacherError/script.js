function setPixelData(pix, i, r, g, b, a) {
	pix[i]   = r;
	pix[i+1] = g;
	pix[i+2] = b;
	pix[i+3] = a
}

function animate() {
	var deltaTime = date.getTime() - lastTime;
	
	ctx.clearRect(0, 0, can.width, can.height); 
	
	var imgd = ctx.getImageData(0, 0, can.width, can.height);
	var pix = imgd.data;
	                                                 
	
	for (var i=0; i<pix.length; i += 4) {
		if (i<can.width * can.height * 4) {
			if (Math.round(Math.random())) {
			     setPixelData(pix, i, 0, 0, 100, 255);
			}
		}
	}
	
	ctx.putImageData(imgd, 0, 0);
	window.requestAnimationFrame(animate);
	lastTime = deltaTime;
}

function init() {
	date = new Date();
	lastTime = date.getTime();
	
	can = document.getElementById("screen");
	ctx = can.getContext("2d");
	window.requestAnimationFrame(animate);       
	can.width = window.innerWidth;
	can.height = window.innerHeight;
}

document.addEventListener("DOMContentLoaded", init, false);