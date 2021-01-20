from django.shortcuts import render
from withdraw.models import NominationWithdraw
from django.db import connection
from reg.models import Registration
# Create your views here.
def withdraw(request):
    objlist = connection.cursor()
    objlist.execute(
        "SELECT * FROM registration,candidate,nomination_withdraw WHERE registration.rid=candidate.rid AND nomination_withdraw.cid=candidate.cid AND nomination_withdraw.status='pending'")

    context={
        'objval' : objlist,

    }

    return render(request, 'withdraw/withdraw.html',context)
def accept(request,idd):

    obj=NominationWithdraw.objects.get(wid=idd)
    obj.status='accept'
    obj.save()
    return withdraw(request)

def reject(request,idd):

    obj=NominationWithdraw.objects.get(wid=idd)
    obj.status='reject'
    obj.save()

    return withdraw(request)