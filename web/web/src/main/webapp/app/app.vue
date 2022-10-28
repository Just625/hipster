<template>
  <div id="app">
    <ribbon></ribbon>
    <div id="app-header">
      <jhi-navbar></jhi-navbar>
    </div>
    <div class="container-fluid">
      <div class="card jh-card">
        <router-view></router-view>
      </div>
      <template>
        <div>
          <a-button type="primary"> Primary </a-button>
          <a-button>Default</a-button>
          <a-button type="dashed"> Dashed </a-button>
          <a-button type="danger"> Danger </a-button>
          <a-config-provider :auto-insert-space-in-button="false">
            <a-button type="primary"> 按钮 </a-button>
          </a-config-provider>
          <a-button type="primary"> 按钮 </a-button>
          <a-button type="link"> Link </a-button>
        </div>
      </template>

      <template>
        <a-form :form="form" :label-col="{ span: 5 }" :wrapper-col="{ span: 12 }" @submit="handleSubmit">
          <a-form-item label="Note">
            <a-input v-decorator="['note', { rules: [{ required: true, message: 'Please input your note!' }] }]" />
          </a-form-item>
          <a-form-item label="Gender">
            <a-select
              v-decorator="['gender', { rules: [{ required: true, message: 'Please select your gender!' }] }]"
              placeholder="Select a option and change input text above"
              @change="handleSelectChange"
            >
              <a-select-option value="male"> male </a-select-option>
              <a-select-option value="female"> female </a-select-option>
            </a-select>
          </a-form-item>
          <a-form-item :wrapper-col="{ span: 12, offset: 5 }">
            <a-button type="primary" html-type="submit"> Submit </a-button>
          </a-form-item>
        </a-form>
      </template>

      <b-modal id="login-page" hide-footer lazy>
        <span data-cy="loginTitle" slot="modal-title" id="login-title">Sign in</span>
        <login-form></login-form>
      </b-modal>

      <jhi-footer></jhi-footer>
    </div>
  </div>
</template>

<script lang="ts" src="./app.component.ts"></script>
