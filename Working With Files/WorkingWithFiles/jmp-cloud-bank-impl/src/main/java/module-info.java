module jmpCloudBankImpl {
    requires transitive jmpBankApi;
    requires jmpDto;
    exports Java8_9_10_11.jmp_cloud_bank_impl.bank;
}