from django.shortcuts import render
from reg.models import Registration
# Create your views here.
def reg(request):
    objlist=Registration.objects.all()
    context={
        'objval' : objlist,
    }

    return render(request, 'reg/viewreg.html',context)


def accept2(request,idd):

    obj=Registration.objects.get(rid=idd)
    obj.status='accept'
    obj.save()
    return reg(request)

def reject2(request,idd):

    obj=Registration.objects.get(rid=idd)
    obj.status='reject'
    obj.save()

    return reg(request)