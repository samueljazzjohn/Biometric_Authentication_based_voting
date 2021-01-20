# This is an auto-generated Django model module.
# You'll have to do the following manually to clean this up:
#   * Rearrange models' order
#   * Make sure each model has one field with primary_key=True
#   * Make sure each ForeignKey and OneToOneField has `on_delete` set to the desired behavior
#   * Remove `managed = False` lines if you wish to allow Django to create, modify, and delete the table
# Feel free to rename the models, but don't rename db_table values or field names.
from django.db import models


class Registration(models.Model):
    rid = models.AutoField(primary_key=True)
    username = models.CharField(max_length=50)
    address = models.CharField(max_length=100)
    phone = models.CharField(max_length=10)
    password = models.CharField(max_length=20)
    email = models.CharField(max_length=25)
    field_adhar = models.CharField(db_column=' adhar', max_length=100)  # Field renamed to remove unsuitable characters. Field renamed because it started with '_'.
    image = models.CharField(max_length=100)
    status = models.CharField(max_length=100)

    class Meta:
        managed = False
        db_table = 'registration'
