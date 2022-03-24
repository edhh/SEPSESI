//var app = new Vue({
//  el: '#app',
//  data: {
//    scanner: null,
//    activeCameraId: null,
//    cameras: [],
//    scans: []
//  },
//  mounted: function () {
//    var qr = "";
//    var separador = "-";
//    var self = this;
//    self.scanner = new Instascan.Scanner({ video: document.getElementById('preview'), scanPeriod: 5 });
//    self.scanner.addListener('scan', function (content) {      
//        console.log(content);
//        qr = content.split(separador);        
//        registrarEntradaPersona(qr[0],qr[1]);        
//        //self.scans.unshift({ date: +(Date.now()), content: content });
//    });
//    
//    Instascan.Camera.getCameras().then(function (cameras) {
//      self.cameras = cameras;      
//      if (cameras.length > 0) {          
//        self.activeCameraId = cameras[0].id;
//        self.scanner.start(cameras[0]);
//      } else {
//        console.error('No cameras found.');
//      }
//    }).catch(function (e) {
//      console.error(e);
//    });
//  },
//  methods: {
//    formatName: function (name) {
//      return name || '(unknown)';
//    },
//    selectCamera: function (camera) {
//      this.activeCameraId = camera.id;
//      this.scanner.start(camera);
//    }
//  }
//}); 



//var qr = "";
//var separador = "-";
//let scanner = new Instascan.Scanner(
//    { 
//        video: document.getElementById('preview') 
//    }
//);
//scanner.addListener('scan', function (content) {
//    qr = content.split(separador);        
//    registrarEntradaPersona(qr[0],qr[1]); 
//});
//
//Instascan.Camera.getCameras().then(function (cameras) {
//if (cameras.length > 0) {
//  scanner.start(cameras[1]);
//} else {
//  console.error('No cameras found.');
//}
//}).catch(function (e) {
//console.error(e);
//});