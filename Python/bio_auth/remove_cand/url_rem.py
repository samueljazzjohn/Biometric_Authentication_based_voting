from django.conf.urls import url
from remove_cand import views


urlpatterns = [
    url('^$', views.remove, name="remove"),
    ]