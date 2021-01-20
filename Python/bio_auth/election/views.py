from django.shortcuts import render
from election.models import Election
# Create your views here.
def election(request):
    if request.method == "POST":
        obj=Election()
        obj.ndate= request.POST.get("nomd")
        obj.wdate= request.POST.get("withd")
        obj.edate= request.POST.get("ed")
        obj.save()

    return render(request, 'election/addel.html')