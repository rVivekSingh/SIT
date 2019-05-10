/**
 * 
 */
var app = new Vue({
    el: '#studentDetails',
    data: {
        sName: null,
        sId: null,
        fName: null,
        mobile: null,
        email: null,
        courses: null,
        totalFee: null,
        date: null
    },
    created: function () {
      this.sName = null
      this.sId = null
      this.fName = null
      this.mobile = null
      this.email = null
      this.courses = null
      this.totalFee = null
      this.date = null
    },
    methods: {
        loginValidate: function (event) {
            app = this;
            axios.post('/seg_app/loginSrv')
                    .then(function (response) {
                        console.log(response)
                     var resp= response.data;
                        if(resp === 'SEG-200') {
                        	window.location.href = "dashboard.html";
                        }
                         
                    })
                    .catch(function (err) {
                        alert(err);
                    });
        }
    }
})