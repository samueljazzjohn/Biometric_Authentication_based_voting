from django.shortcuts import render
from nom.models import Nomination
from reg.models import Registration
from django.db import connection
# Create your views here.
def nom(request):
    objlist = connection.cursor()
    objlist.execute(
        "SELECT * FROM registration,nomination WHERE registration.rid=nomination.rid  ")

    context={
        'objval' : objlist,
    }
    return render(request, 'nom/viewnom.html',context)

def accept1(request,idd):

    obj=Nomination.objects.get(nid=idd)
    obj.status='accept'
    obj.save()
    return nom(request)

def reject1(request,idd):

    obj=Nomination.objects.get(nid=idd)
    obj.status='reject'
    obj.save()

    return nom(request)