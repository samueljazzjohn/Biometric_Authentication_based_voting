from django.shortcuts import render
from remove_cand.models import Candidate
# Create your views here.
def remove(request):
    objlist=Candidate.objects.all()
    context={
        'objval' : objlist,
    }
    return render(request, 'remove_cand/remove.html',context)