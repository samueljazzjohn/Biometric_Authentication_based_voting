from django.shortcuts import render
from login.models import Login

# Create your views here.
def login(request):
    if request.method == "POST":
        uname = request.POST.get("uname")
        passw = request.POST.get("pass")

        obj = Login.objects.filter(username=uname, password=passw)
        tp = ""
        for ob in obj:
            tp = ob.type
            uid = ob.lid
            if tp == "admin":
                request.session['admin'] = uid

                return render(request, 'login/adminhome.html')

            else:

                context={
                    'msg':'Invalid Credentials',
                }
                return render(request, 'login/Login.html',context)


    return render(request, 'login/Login.html')


def logout(request):
    request.session['admin'] = ''

    return login(request)
